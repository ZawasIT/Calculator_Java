package com.calculator.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlertController {

    @FXML
    private Label labelDesc;

    @FXML
    private Label labelTitle;

    private String labelTitleText;
    private String labelDescText;

    public void initData(String labelTitleText, String labelDescText) {
        labelTitle.setText(labelTitleText);
        labelDesc.setText(labelDescText);
    }

}
