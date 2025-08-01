import Server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server("Admin",1);
        server.setServerSocket();



    }
}
