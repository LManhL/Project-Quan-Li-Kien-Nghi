package com.example.projectquanlikiennghi.controller.controllerUser.ThongTinUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerUser.UserMainController;
import com.example.projectquanlikiennghi.models.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ThongTinUserController implements Initializable {

    private JdbcDAO repo=new JdbcDAO();
    @FXML
    private Label dia_chi_label;

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
    void changePassword(ActionEvent event) throws IOException {
        UserMainController uhc = new UserMainController();
        uhc.change_Bphu("UserFXML/changePassword.fxml");
    }
    @FXML
    void changeUserInformation(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader=new FXMLLoader(Main.class.getResource("UserFXML/changeUserInformation.fxml"));
        Parent root=loader.load();
        SuaThongTinController controller=loader.getController();
        controller.initialValue();
        UserMainController.global_phu.setCenter(root);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Account account = new Account();
        try {
            account = repo.loadUserInformation(UserMainController.username, UserMainController.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ho_ten_label.setText(account.getHovaten());
        gioi_tinh_label.setText(account.getGioitinh());
        ma_cccd_label.setText(account.getCCCD());
        so_dt_label.setText(account.getSDT());
        ngay_sinh_label.setText(account.getNamsinh());
        dia_chi_label.setText(account.getDiachi());
    }



    public void showUser(Account acc) {
        ho_ten_label.setText(acc.getHovaten());
        gioi_tinh_label.setText(acc.getGioitinh());
        ma_cccd_label.setText(acc.getCCCD());
        so_dt_label.setText(acc.getSDT());
        ngay_sinh_label.setText(acc.getNamsinh());
        dia_chi_label.setText(acc.getDiachi());
    }
}