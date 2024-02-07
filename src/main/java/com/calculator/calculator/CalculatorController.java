package com.calculator.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField displayTextField;

    @FXML
    private Button addBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button numberBtn;

    @FXML
    private Button resultBtn;

    @FXML
    void handleClearButtonClick(ActionEvent event) {
        result = 0.0;
        operation = "";
        displayTextField.setText("");
        displayTextField.setEditable(true);
    }

    @FXML
    void handleDeleteButtonClick(ActionEvent event) {
        if(!displayTextField.getText().equals("")) {
            displayTextField.setText(displayTextField.getText().substring(0, displayTextField.getText().length() - 1));
        }
    }

    @FXML
    void handleSignChangeButtonClick(ActionEvent event) {
        if(displayTextField.getText().equals("")) {
            displayTextField.setText(displayTextField.getText());
        } else {
            Double value = Double.valueOf(displayTextField.getText());
            System.out.println(value);

            if(!value.equals(0.0)) {
                value *= -1;
            }
            displayTextField.setText(String.valueOf(value));
        }
    }

    @FXML
    void handleButtonClick(ActionEvent event) {
        Button buttonClicked = (Button) event.getSource();
        String buttonText = buttonClicked.getText();

        String currentText = displayTextField.getText();

        if(buttonText.equals(".")) {
            if(displayTextField.getText().equals("")){
                displayTextField.setText("0" + buttonText);
            } else if (!displayTextField.getText().contains(".")) {
                displayTextField.setText(currentText + buttonText);
            }
        } else {
            displayTextField.setText(currentText + buttonText);
        }
    }


    @FXML
    void handleOperationButtonClick(ActionEvent event) {
        // pobranie wartości do String operation
        Button buttonClicked = (Button) event.getSource();
        String operationButton = buttonClicked.getText();

        if(operationButton.equals("X")) {
            operation = "*";
        } else {
            operation = operationButton;
        }

        // pobranie obecnej wartości z wyświetlacza do Double result
        String currentText = displayTextField.getText();
        if(currentText.equals("")) {
            currentText = "0";
        }
        result = Double.valueOf(currentText);

        // wyzerowanie wyświetlacza
        displayTextField.setText("");
    }

    @FXML
    void handleResultButtonClick(ActionEvent event) {
        System.out.println(operation);
        Double value;
        switch (operation) {
            case "+": {
                value = result + Double.valueOf(displayTextField.getText());
                displayTextField.setText(String.valueOf(value));
                break;
            }
            case "-": {
                value = result - Double.valueOf(displayTextField.getText());
                displayTextField.setText(String.valueOf(value));
                break;
            }
            case "*": {
                value = result * Double.valueOf(displayTextField.getText());
                displayTextField.setText(String.valueOf(value));
                break;
            }

            case "/": {

                if(displayTextField.getText().equals("0")) {
                    AlertView.showAlert("Błąd", "Nie dziel przez zero!");
                    /*displayTextField.setText("Nie dziel przez 0");
                    displayTextField.setEditable(false);*/
                } else {
                    value = result / Double.valueOf(displayTextField.getText());
                    displayTextField.setText(String.valueOf(value));
                }
                break;
            }

            case "%":{
                value = (result * Double.valueOf(displayTextField.getText())) /100;
                displayTextField.setText(String.valueOf(value));
                break;
            }
            default:
                displayTextField.setText("");
                break;

        }
    }

    private Double result = Double.valueOf(0);
    private String operation = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}