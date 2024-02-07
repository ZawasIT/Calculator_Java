package com.calculator.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertView {
    public static void showAlert(String title, String text) {
        try {
            FXMLLoader loader = new FXMLLoader(AlertView.class.getResource("/com/calculator/calculator/alert.fxml"));
            Parent root = loader.load();

            AlertController alertController = loader.getController();
            alertController.initData(title, text);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
