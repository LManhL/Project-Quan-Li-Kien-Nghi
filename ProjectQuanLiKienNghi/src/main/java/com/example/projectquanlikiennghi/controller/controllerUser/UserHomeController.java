package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;

public class UserHomeController implements Initializable {
    @FXML
    private Button buttonLogout;
    @FXML
    public  BorderPane Bpane_phu  ;

    public  static  BorderPane global_phu ;
    public static String username;
    public static String password;

    public void userLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LoginFXML/login.fxml");
        Main.globalState.setWidth(597);
        Main.globalState.setHeight(459);
    }

    // set ten va matkhau cho lop , tu do cos the query
    public void setInitialValue(String username,String password){
        this.username=username;
        this.password=password;
        System.out.println(username+password);
    }
    public void change_Bphu(String str) throws IOException {
        Parent p = new FXMLLoader().load(Main.class.getResource(str));

//        Bpane_phu.setCenter(p);
        global_phu.setCenter(p);
    }

    @FXML
    void userInformation(ActionEvent event) throws IOException {

        change_Bphu("UserFXML/userInformation.fxml");
    }

    @FXML
    void userList(ActionEvent event) throws IOException {

        change_Bphu("UserFXML/DSKiennghiUser.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ta dung gloval_phu static de lam cho lop UserHomecontroller chi su dung chung 1 bo nho cho borderpane
        global_phu = Bpane_phu;
    }
}