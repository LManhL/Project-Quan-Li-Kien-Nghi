package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class SuaInfoUserController implements Initializable {

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
    private Button change;

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

    public void buttonChange() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận ");
        alert.setContentText("Xác nhận cập nhật");

        ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes) {
            String hvt = hoten.getText();
            String gioitinh = gender.getText();
            String address = diachi.getText();
            String namsinh = birth.getText();
            String phone_num = sdt.getText();
            String usm = username.getText();

            try {
                Integer d = Integer.parseInt(namsinh);
            } catch (NumberFormatException nfe) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Năm sinh không đúng định dạng");
                alert.show();
            }

            repo.AdminchangeUserInf(hvt, gioitinh, address, namsinh, phone_num, cccd, usm);
            status.setText("Cập nhật thành công");
            status.setVisible(true);
            change.setVisible(false);
        } else{

        }
    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }
}
