package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.models.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class userInformationController implements Initializable {
    @FXML
    private Label dia_chi_label;

    @FXML
    private Button exit_thongtin;

    @FXML
    private Label gioi_tinh_label;

    @FXML
    private Label ho_ten_label;

    @FXML
    private Label ma_cccd_label;

    @FXML
    private Label ngay_sinh_label;

    @FXML
    private Label so_dt_label;

    @FXML
    void click_exit(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("afterLoginUser.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Account account = new Account();
        ho_ten_label.setText(account.getHovaten());
        gioi_tinh_label.setText(account.getGioitinh());
        ma_cccd_label.setText(account.getCCCD());
        so_dt_label.setText(account.getSDT());
        ngay_sinh_label.setText(account.getNamsinh());
        dia_chi_label.setText(account.getDiachi());

    }
}