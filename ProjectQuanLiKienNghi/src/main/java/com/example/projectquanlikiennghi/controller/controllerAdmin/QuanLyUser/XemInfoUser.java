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
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class XemInfoUser implements Initializable {

    @FXML
    private TextField hoten;
    @FXML
    private TextField gender;
    @FXML
    private TextField diachi;
    @FXML
    private TextField birth;
    @FXML
    private TextField sdt;
    @FXML
    private TextField username;

    @FXML
    private Label status;

    @FXML
    private Button button_back;
    private JdbcDAO repo = new JdbcDAO();

    private String cccd;

    @FXML
    private ImageView back_buttonimg;

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
    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }
}
