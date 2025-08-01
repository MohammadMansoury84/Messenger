package org.example.demo13;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class ChatController {

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField inputField;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private String username = "کاربر ناشناس";

    public void setUsername(String username) {
        this.username = username;
    }

    public void initialize() {
        try {
            socket = new Socket("127.0.0.1", 1234);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = input.readUTF();
                        Platform.runLater(() -> chatArea.appendText(message + "\n"));
                    }
                } catch (IOException e) {
                    Platform.runLater(() -> chatArea.appendText(" ارتباط قطع شد.\n"));
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();
        } catch (IOException e) {
            chatArea.appendText("اتصال به سرور ممکن نیست.\n");
        }
    }

    @FXML
    public void onSend() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        String myMessage = username + ": " + text;
        chatArea.appendText(myMessage + "\n");

        try {
            output.writeUTF(myMessage);
            inputField.clear();

            if (text.equalsIgnoreCase("END")) {
                socket.close();
                chatArea.appendText(" ارتباط با سرور پایان یافت.\n");
            }

        } catch (IOException e) {
            chatArea.appendText(" خطا در ارسال پیام به سرور.\n");
        }
    }
}
