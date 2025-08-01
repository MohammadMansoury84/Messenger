package org.example.demo13;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void onLogin() {
        String username = usernameField.getText().trim();

        if (username.isEmpty()) {
            showAlert("خطا", "لطفاً نام کاربری را وارد کنید");
            return;
        }

        try {

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();


            FXMLLoader loader = new FXMLLoader( getClass().getResource("chat-view.fxml"));
            Parent root = loader.load();


            ChatController chatController = loader.getController();
            chatController.setUsername(username);

            Stage chatStage = new Stage();
            chatStage.setScene(new Scene(root));
            chatStage.setTitle("Mamad Chat Pro - " + username);
            chatStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("خطا", "مشکلی در اجرای برنامه پیش آمده است");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);


        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(
                "-fx-background-color: #121212; " +
                        "-fx-text-fill: #e0e0e0; " +
                        "-fx-border-color: #252525;"
        );

        alert.showAndWait();
    }
}