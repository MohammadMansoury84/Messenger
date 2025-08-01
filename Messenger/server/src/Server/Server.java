package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server  {

    private String name;
    private int id;
    private List<ServerCommunication> connectedPeople;
    private List<String> previousMessages;
    ServerSocket serverSocket;

    public Server(String name, int id) throws IOException {
        this.name = name;
        this.id = id;
        this.connectedPeople= Collections.synchronizedList(new ArrayList<>());
        this.serverSocket=new ServerSocket(1234);
        this.previousMessages=Collections.synchronizedList(new ArrayList<>());
    }



    public void setServerSocket() throws IOException {
        while (true){
            Socket socket=serverSocket.accept();
            System.out.println("ping:"+socket.getInetAddress()+" | "+socket.getPort());
            ServerCommunication serverCommunication=new ServerCommunication(this.name,this.id,socket);
            serverCommunication.setServer(this);
            connectedPeople.add(serverCommunication);
            sendPreviousMessages(serverCommunication);
            serverCommunication.start();
        }
    }

    public synchronized void sendMessageToOther(String message,ServerCommunication serverCommunication) throws IOException {
        for (ServerCommunication otherClient:connectedPeople){
            if (otherClient!=serverCommunication) {
                otherClient.send(message);
            }
        }
    }

    public synchronized void sendPreviousMessages(ServerCommunication serverCommunication) throws IOException {
        for (String message : previousMessages) {
            serverCommunication.send(message);

        }
    }
    public synchronized void sendPvRequest(ServerCommunication serverCommunication) throws IOException {
        for (ServerCommunication serverCommunication1:connectedPeople) {
            serverCommunication.send(String.valueOf(serverCommunication1.getIdOfUser()));
        }
    }
    public synchronized void sendPvMessage(String message, ServerCommunication target) throws IOException {
        if (target != null) {
            target.send("PV message: " + message);
        }
    }

    public void removeClient(ServerCommunication serverCommunication) {
        connectedPeople.remove(serverCommunication);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<String> getPreviousMessages() {
        return previousMessages;
    }

    public void setPreviousMessages(List<String> previousMessages) {
        this.previousMessages = previousMessages;
    }

    public List<ServerCommunication> getConnectedPeople() {
        return connectedPeople;
    }

    public void setConnectedPeople(List<ServerCommunication> connectedPeople) {
        this.connectedPeople = connectedPeople;
    }
}
