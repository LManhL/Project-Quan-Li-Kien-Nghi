package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;

public class Login {
    @FXML
    private Label wrongLogin;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton rdAdmin;
    @FXML
    private RadioButton rdUser;

    private String nextScene="";
    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }
    private void checkLogin() throws IOException {

        if(nextScene.equals("")){
            wrongLogin.setText("Please choose admin or user account");
        }
        else{
            if(rdAdmin.isSelected()){
                checkLoginSelected("admin","admin");
            }
            else if(rdUser.isSelected()){
                checkLoginSelected("user","user");
            }
        }
    }
    public void getScreen(ActionEvent event){
        if(rdAdmin.isSelected()){
            nextScene="afterLoginAdmin.fxml";
        }
        else if(rdUser.isSelected()){
            nextScene="afterLoginUser.fxml";
        }
    }
    public void checkLoginSelected(String usernameText,String passwordText) throws IOException {
        Main m = new Main();
        if(username.getText().toString().equals(usernameText) && password.getText().toString().equals(passwordText)) {
            wrongLogin.setText("Success!");
            m.changeScene(nextScene);
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
        }
        else {
            wrongLogin.setText("Wrong username or password!");
        }
    }

}
