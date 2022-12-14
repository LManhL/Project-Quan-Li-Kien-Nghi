package com.example.projectquanlikiennghi.controller.controllerAdmin;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.Account;
import com.example.projectquanlikiennghi.models.KienNghi;
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

public class DSKienNghi  implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private TableView<KienNghi> table = new TableView<KienNghi>();

    @FXML
    private TableColumn<Account, Integer> STT = new TableColumn<Account, Integer>();
    @FXML
    private TableColumn<Account, String> Ma_kien_nghi = new TableColumn<Account, String>();
    @FXML
    private TableColumn<Account, String> Ngaygui = new TableColumn<>();
    @FXML
    private TableColumn<Account, String> Noidung = new TableColumn<Account, String>();
    @FXML
    private TableColumn<Account, Integer> Trangthai = new TableColumn<>();
    @FXML
    private TableColumn<Account, String> Noidungphanhoi = new TableColumn<>();
    @FXML
    private TableColumn<Account, String> Ngayphanhoi = new TableColumn<Account, String>();
    @FXML
    private TableColumn<Account, String> Loai = new TableColumn<Account, String>();

    JdbcDAO repo = new JdbcDAO();

    ObservableList<KienNghi> listKN = FXCollections.observableArrayList();

   public void loadKN() throws SQLException {
       STT.setCellValueFactory( new PropertyValueFactory<Account, Integer>("STT"));
       Ma_kien_nghi.setCellValueFactory( new PropertyValueFactory<Account, String>("Ma_kien_nghi"));
       Ngaygui.setCellValueFactory( new PropertyValueFactory<Account, String>("Ngaygui"));
       Noidung.setCellValueFactory( new PropertyValueFactory<Account, String>("Noidung"));
       Trangthai.setCellValueFactory( new PropertyValueFactory<Account, Integer>("Trangthai"));
       Noidungphanhoi.setCellValueFactory( new PropertyValueFactory<Account, String>("Noidungphanhoi"));
       Ngayphanhoi.setCellValueFactory( new PropertyValueFactory<Account, String>("Ngayphanhoi"));
       Loai.setCellValueFactory( new PropertyValueFactory<Account, String>("Loai"));

       listKN = repo.listKN();
       table.setItems(listKN);
       //table.getColumns().addAll(STT,Hovaten,SDT,Diachi,Gioitinh,Namsinh,CCCD,Username,SoKN );
   }
}
