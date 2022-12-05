package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.doituong.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class informationController implements Initializable {
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
        User u = new User();
        ho_ten_label.setText(u.getHo_ten());
        gioi_tinh_label.setText(u.getGioi_tinh());
        ma_cccd_label.setText(u.getSo_cccd());
        so_dt_label.setText(u.getSo_dt());
        ngay_sinh_label.setText(u.getNgay_sinh());
        dia_chi_label.setText(u.getDia_chi());

    }
}
