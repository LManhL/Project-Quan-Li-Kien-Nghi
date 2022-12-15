package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import com.example.projectquanlikiennghi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UserHomeController {
    @FXML
    private Button buttonLogout;
    @FXML
    private BorderPane Bpane_phu;

    public void userLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LoginFXML/login.fxml");
    }


    @FXML
    void userInformation(ActionEvent event) throws IOException {
        Parent p = null;
        p = new FXMLLoader().load(Main.class.getResource("UserFXML/userInformation.fxml"));

        Bpane_phu.setCenter(p);
    }

    @FXML
    void userList(ActionEvent event) throws IOException {
        Parent p = null;
        p = new FXMLLoader().load(Main.class.getResource("UserFXML/DSKiennghiUser.fxml"));

        Bpane_phu.setCenter(p);
    }

}