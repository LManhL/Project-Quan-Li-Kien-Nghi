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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private TextField role;
    @FXML
    private Button buttonSummit;
    @FXML
    private Label status;
    @FXML
    private Button button_back;
    @FXML
    private ImageView back_buttonimg;
    JdbcDAO repo = new JdbcDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void summit(ActionEvent event) throws IOException, SQLException {
        String hoten = Hovaten.getText();
        String sdt = SDT.getText();
        String diachi = Diachi.getText();
        String gioitinh ;
        if (Men.isSelected()) { gioitinh = "Nam"; }
        else gioitinh = "Nữ";
        String namsinh = Namsinh.getText();
        String cccd = CCCD.getText();
        String usn = username.getText();
        String pass = password.getText();
        String rl = role.getText();

        Account acc = new Account(hoten,sdt,diachi,gioitinh,namsinh,
                                  cccd, usn, pass, rl);
        repo.InsertUser(acc);
        status.setVisible(true);
        buttonSummit.setVisible(false);

    }
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }

}
