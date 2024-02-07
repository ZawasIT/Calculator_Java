package com.calculator.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AlertView {
    public static void showAlert(String title, String text, String buttonText) {
        try {
            FXMLLoader loader = new FXMLLoader(AlertView.class.getResource("/com/calculator/calculator/alert.fxml"));
            Parent root = loader.load();

            AlertController alertController = loader.getController();
            alertController.initData(title, text, buttonText);

            Stage stage = new Stage();
            stage.getIcons().add(new Image(String.valueOf(AlertView.class.getResource("/img/calculator.png"))));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
