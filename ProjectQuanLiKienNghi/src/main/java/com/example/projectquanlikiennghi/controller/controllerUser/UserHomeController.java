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
    public static BorderPane Bpane_phu;

    public  static  BorderPane global_phu;
    public static String username;
    public static String password;

    public void userLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LoginFXML/login.fxml");
    }

    public void setInitialValue(String username,String password){
//        global_phu = Bpane_phu;
        this.username=username;
        this.password=password;
        System.out.println(username+password);
    }
    public static void change_Bphu(String str) throws IOException {
        Parent p = new FXMLLoader().load(Main.class.getResource(str));

        Bpane_phu.setCenter(p);
//        global_phu.setCenter(p);
    }

    @FXML
    void userInformation(ActionEvent event) throws IOException {

        change_Bphu("UserFXML/userInformation.fxml");
    }

    @FXML
    void userList(ActionEvent event) throws IOException {

        change_Bphu("UserFXML/DSKiennghiUser.fxml");
    }

}