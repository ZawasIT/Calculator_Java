package com.calculator.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

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
    }
    @FXML
    void handleButtonClick(ActionEvent event) {
        Button buttonClicked = (Button) event.getSource();
        String buttonText = buttonClicked.getText();
        String currentText = displayTextField.getText();

        displayTextField.setText(currentText + buttonText);
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
                value = result / Double.valueOf(displayTextField.getText());
                displayTextField.setText(String.valueOf(value));
                break;
            }
        }
    }

    private Double result = Double.valueOf(0);
    private String operation;
}