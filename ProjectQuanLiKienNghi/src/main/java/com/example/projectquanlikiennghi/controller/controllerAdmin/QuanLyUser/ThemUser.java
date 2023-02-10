package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.Account;
import javafx.event.ActionEvent;
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

public class ThemUser implements Initializable {

    @FXML
    private TextField Hovaten;
    @FXML
    private RadioButton Men;
    @FXML
    private RadioButton Women;
    @FXML
    private TextField SDT;
    @FXML
    private TextField Diachi;
    @FXML
    private TextField Namsinh;
    @FXML
    private TextField CCCD;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button buttonSummit;
    @FXML
    private Label status;
    @FXML
    private Button button_back;
    @FXML
    private ImageView back_buttonimg;
    private JdbcDAO repo = new JdbcDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void summit(ActionEvent event) throws IOException, SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận ");
        alert.setContentText("Xác nhận thêm người dùng");

        ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes) {
            String hoten = Hovaten.getText();
            String sdt = SDT.getText();
            String diachi = Diachi.getText();
            String gioitinh;
            if (Men.isSelected()) {
                gioitinh = "Nam";
            } else gioitinh = "Nữ";
            String namsinh = Namsinh.getText();
            String cccd = CCCD.getText();
            String usn = username.getText();
            String pass = password.getText();

            try {
                Integer d = Integer.parseInt(namsinh);
            } catch (NumberFormatException nfe) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Năm sinh không đúng định dạng");
                alert.show();
            }

            Account acc = new Account(hoten, sdt, diachi, gioitinh, namsinh,
                    cccd, usn, pass, "user");
            repo.InsertUser(acc);
            status.setVisible(true);
            buttonSummit.setVisible(false);
        }else {
            // nothing
        }
    }
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }

}
