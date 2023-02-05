package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class XemInfoUser implements Initializable {

    @FXML
    TextField hoten;
    @FXML
    TextField gender;
    @FXML
    TextField diachi;
    @FXML
    TextField birth;
    @FXML
    TextField sdt;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    Label status;

    @FXML
    Button button_back;
    JdbcDAO repo = new JdbcDAO();

    String cccd;

    @FXML
    ImageView back_buttonimg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
    public void set_inf(Account acc){
        cccd = acc.getCCCD();

        hoten.setText(acc.getHovaten());
        gender.setText(acc.getGioitinh());
        diachi.setText(acc.getDiachi());
        birth.setText(acc.getNamsinh());
        sdt.setText(acc.getSDT());
        username.setText(acc.getUsername());
        password.setText(acc.getPassword());
    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }
}
