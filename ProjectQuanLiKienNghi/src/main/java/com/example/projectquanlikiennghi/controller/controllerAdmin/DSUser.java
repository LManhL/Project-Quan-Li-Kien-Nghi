package com.example.projectquanlikiennghi.controller.controllerAdmin;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DSUser implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private TableView<Account> table = new TableView<Account>();
    @FXML
    TableColumn<Account, Integer> STT = new TableColumn<Account, Integer>("STT");
    @FXML
    TableColumn<Account, String> Hovaten = new TableColumn<Account, String>("Họ và tên");
    @FXML
    TableColumn<Account, String> SDT = new TableColumn<>("SDT");
    @FXML
    TableColumn<Account, String> Diachi = new TableColumn<>("Địa chỉ");
    @FXML
    TableColumn<Account, String> Gioitinh = new TableColumn<>("Giới tính");
    @FXML
    TableColumn<Account, String> Namsinh = new TableColumn<>("Năm sinh");
    @FXML
    TableColumn<Account, String> CCCD = new TableColumn<Account, String>("CCCD");
    @FXML
    TableColumn<Account, String> Username = new TableColumn<>("Username");
    @FXML
    TableColumn<Account, Integer> SoKN = new TableColumn<>("Số KN");


    JdbcDAO repo = new JdbcDAO();

    ObservableList<Account> list = FXCollections.observableArrayList();

    public void loadUser() throws SQLException {
        STT.setCellValueFactory( new PropertyValueFactory<Account, Integer>("ID"));
        Hovaten.setCellValueFactory( new PropertyValueFactory<Account, String>("Hovaten"));
        SDT.setCellValueFactory( new PropertyValueFactory<Account, String>("SDT"));
        Diachi.setCellValueFactory( new PropertyValueFactory<Account, String>("Diachi"));
        Gioitinh.setCellValueFactory( new PropertyValueFactory<Account, String>("Gioitinh"));
        Namsinh.setCellValueFactory( new PropertyValueFactory<Account, String>("Namsinh"));
        CCCD.setCellValueFactory( new PropertyValueFactory<Account, String>("CCCD"));
        Username.setCellValueFactory( new PropertyValueFactory<Account, String>("Username"));
        SoKN.setCellValueFactory( new PropertyValueFactory<Account, Integer>("SoKN"));

        list = repo.listUser();
        table.setItems(list);
        //table.getColumns().addAll(STT,Hovaten,SDT,Diachi,Gioitinh,Namsinh,CCCD,Username,SoKN );
    }
}
