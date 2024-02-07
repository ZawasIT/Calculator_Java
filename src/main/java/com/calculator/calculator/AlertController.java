package com.calculator.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertController {

    @FXML
    private Label labelDesc;

    @FXML
    private Label labelTitle;

    @FXML
    private Button buttonAlert;

    private String labelTitleText;
    private String labelDescText;

    public void initData(String labelTitleText, String labelDescText, String buttonText) {
        labelTitle.setText(labelTitleText);
        labelDesc.setText(labelDescText);
        buttonAlert.setText(buttonText);
    }

    @FXML
    void closeWindow(ActionEvent event) {
       Stage stage = (Stage) buttonAlert.getScene().getWindow();
       stage.close();
    }

}
