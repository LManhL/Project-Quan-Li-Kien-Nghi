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


    @FXML
    private TableView<KienNghi> table = new TableView<KienNghi>();

    @FXML
    private TableColumn<KienNghi, Integer> STT = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Ma_kien_nghi = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Ngaygui = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Noidung = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, Integer> Trangthai = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Noidungphanhoi = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Ngayphanhoi = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Loai = new TableColumn<>();

    JdbcDAO repo = new JdbcDAO();

    ObservableList<KienNghi> listKN = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       STT.setCellValueFactory( new PropertyValueFactory<KienNghi, Integer>("STT"));
       Ma_kien_nghi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ma_kien_nghi"));
       Ngaygui.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ngaygui"));
       Noidung.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Noidung"));
       Trangthai.setCellValueFactory( new PropertyValueFactory<KienNghi, Integer>("Trangthai"));
       Noidungphanhoi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Noidungphanhoi"));
       Ngayphanhoi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ngayphanhoi"));
       Loai.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Loai"));

        try {
            listKN = repo.listKN();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setItems(listKN);
       //table.getColumns().addAll(STT,Hovaten,SDT,Diachi,Gioitinh,Namsinh,CCCD,Username,SoKN );
   }
}
