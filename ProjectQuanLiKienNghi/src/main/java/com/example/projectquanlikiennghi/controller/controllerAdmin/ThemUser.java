package com.example.projectquanlikiennghi.controller.controllerAdmin;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ThemUser implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

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

    JdbcDAO repo = new JdbcDAO();

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


    }

}
