package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField adress;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    protected void onSignup() {

        String inputName=name.getText();
        String inputSurname=surname.getText();

        String inputAdress=adress.getText();
        int inputPhone= Integer.parseInt(phone.getText());
        String inputEmail=email.getText();
System.out.println("Information is saved");
    }
}