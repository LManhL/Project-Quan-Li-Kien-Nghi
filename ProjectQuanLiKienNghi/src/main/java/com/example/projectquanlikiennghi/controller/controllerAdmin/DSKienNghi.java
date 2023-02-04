package com.example.projectquanlikiennghi.controller.controllerAdmin;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerUser.XemKienNghiUserController;
import com.example.projectquanlikiennghi.models.Account;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.IOException;
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


    private ContextMenu contextMenu;
    private MenuItem mi_xem;
    private MenuItem mi_xoa;

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


        contextMenu = new ContextMenu();

        mi_xem = new MenuItem("Xem");
        mi_xem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("UserFXML/showKienNghi.fxml"));
                    Parent p = loader.load();
                    XemKienNghiUserController knc = loader.getController();
                    knc.set_inf(kn.getLoai(),kn.getMa_kien_nghi(),kn.getNoidung(),
                                kn.getNoidungphanhoi(),kn.getNgaygui(),kn.getNgayphanhoi(),
                                String.valueOf(kn.getSTT()),String.valueOf(kn.getTrangthai()));
                    AdminHomeController.global_pane.setCenter(p);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xem);


        mi_xoa = new MenuItem("Xoa");
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    repo.delete_kn(kn.getMa_kien_nghi());
                    System.out.println("xoa kn thanh cong");
                } catch (SQLException e) {
                    System.out.println("xoa kn that bai");
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xoa);

        table.setRowFactory(new Callback<TableView<KienNghi>, TableRow<KienNghi>>() {
            @Override
            public TableRow<KienNghi> call(TableView<KienNghi> param) {
                final TableRow<KienNghi> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(event.getButton() == MouseButton.SECONDARY && !row.isEmpty()){
                            contextMenu.show(table,event.getScreenX(),event.getScreenY());
                        }
                        else {
                            contextMenu.hide();
                        }
                    }

                });
                return row;
            }
        });
   }
}
