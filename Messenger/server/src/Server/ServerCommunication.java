package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class ServerCommunication extends Thread{
    private String name;
    private int id;
    private static int idCounter = 1;
    private Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    private Server server;


    public ServerCommunication(String name, int id, Socket socket) throws IOException {
        this.name = name;
        this.id = idCounter++;
        this.socket=socket;
        dataOutputStream=new DataOutputStream(this.socket.getOutputStream());
        dataInputStream=new DataInputStream(this.socket.getInputStream());

    }

    @Override
    public void run() {
        try {
            while (true) {
                String message;
                message = dataInputStream.readUTF();
                this.name=message;
                server.getPreviousMessages().add(message);
                System.out.println(message);
                server.sendMessageToOther(message,this);

                if (searchMessage(message).equals("Good bye!")){
                    server.removeClient(this);
                    String[] word=message.split(":");
                    server.sendMessageToOther(word[0]+" has left the chat.",this);
                }

                if (searchMessage(message).equals("PV")){
                    server.sendPvRequest(this);
                    send("Enter target user ID:");
                    String targetIdStr = dataInputStream.readUTF();
                    String[] targetId=targetIdStr.split(":");
                    ServerCommunication targetUser = findUser(Integer.parseInt(targetId[1]));

                    if (targetUser != null) {
                        send("You can start private messaging. Type END PV to finish.");
                        while (true) {
                            String privateMessage = dataInputStream.readUTF();
                            if (searchMessage(privateMessage).equals("END PV")) {
                                send("Private chat ended.");
                                break;
                            }
                            server.sendPvMessage(  " (private): " + privateMessage, targetUser);
                        }
                    } else {
                        send("User with ID " + targetId + " not found.");
                    }
                }


            }
        } catch (IOException e) {
            try {
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public String searchMessage(String message){
        if (message.contains(":")){
            String[] word=message.split(":");
            return word[1];
        }
        return "not found";
    }

    public void send(String message) throws IOException {
        dataOutputStream.writeUTF(message);
    }

    public ServerCommunication findUser(int id){
        for (ServerCommunication serverCommunication:server.getConnectedPeople()){
            if (serverCommunication.id==id){
                return serverCommunication;
            }
        }
        return null;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getNameOfUser() {
        return name;
    }

    public void setNameOfUser(String name) {
        this.name = name;
    }

    public int getIdOfUser() {
        return id;
    }

    public void setIdOfUser(int id) {
        this.id = id;
    }
}
