package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerUser.UserMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class LoginController {
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

    private JdbcDAO repo = new JdbcDAO();
    private String nextScene="";
    public void userLogIn(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }
    private void checkLogin() throws IOException, SQLException {

        if(nextScene.equals("")){
            wrongLogin.setText("Please choose admin or user account");
        }
        else{
            if(rdAdmin.isSelected()){
                checkLoginSelectedAdmin();
            }
            else if(rdUser.isSelected()){
                checkLoginSelectedUser();
            }
        }
    }
    public void getScreen(ActionEvent event){
        if(rdAdmin.isSelected()){
            nextScene="AdminFXML/AdminHome.fxml";
        }
        else if(rdUser.isSelected()){
            nextScene="UserFXML/UserHome.fxml";
        }
    }
    public void checkLoginSelectedUser() throws IOException, SQLException {

        Main m =new Main();
        if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
            return;
        }
        Map<String,String> map=repo.checkloginUser();
        if(map.containsKey(username.getText().toString())){
            if(map.get(username.getText().toString()).equals(password.getText().toString())){
                wrongLogin.setText("Success!");

                FXMLLoader loader = new FXMLLoader(m.getClass().getResource(nextScene));
                Parent parent = loader.load();

                UserMainController userHomeController=loader.getController();
                userHomeController.setInitialValue(username.getText().toString(),password.getText().toString());

                m.changeScene(nextScene);
                Main.globalState.setWidth(1239.0);
                Main.globalState.setHeight(730.0);
            }
            else{
                wrongLogin.setText("Wrong username or password");
            }
        }
        else{
            wrongLogin.setText("Wrong username or password");
        }
    }
    public void checkLoginSelectedAdmin() throws IOException {
        Main m =new Main();
        if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
            return;
        }
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            wrongLogin.setText("Success!");

            m.changeScene(nextScene);
            Main.globalState.setWidth(1100.0);
            Main.globalState.setHeight(730.0);
        }
        else{
            wrongLogin.setText("Wrong username or password");
        }
    }

}
