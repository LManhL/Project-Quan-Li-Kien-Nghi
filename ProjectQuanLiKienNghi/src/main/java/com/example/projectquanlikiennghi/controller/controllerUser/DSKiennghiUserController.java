package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
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

public class DSKiennghiUserController implements Initializable {
    //khai bao 2 bien de lay thong tin, 2 thong tin duoc lay tu userhomcontroller

    @FXML
    private TableView<KienNghi> bang;

    @FXML
    private TableColumn<KienNghi, Integer> id_cot;

    @FXML
    private TableColumn<KienNghi, String> ngaygui_cot;

    @FXML
    private TableColumn<KienNghi, Integer> trangthai_cot;

    public DSKiennghiUserController() {
    }

    @FXML
    void click_them(ActionEvent event) {

    }
    // tao thong tin khi click chuot phai
    private ContextMenu contextMenu;
    private MenuItem    mi_xem;
    private MenuItem    mi_sua;
    private MenuItem    mi_xoa;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        id_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,Integer>("STT"));
        ngaygui_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("Ngaygui"));
        trangthai_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,Integer>("Trangthai"));

        //lay kien nghi cua 1 ca nhan
        JdbcDAO repo = new JdbcDAO();
        ObservableList<KienNghi> listofuser = FXCollections.observableArrayList();
        try {
            listofuser = repo.getKienNghiuser(UserHomeController.username,UserHomeController.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bang.setItems(listofuser);

        //gan su kien cho menuitem cua contextMenu
        contextMenu = new ContextMenu();
        mi_xem = new MenuItem("Xem");
        mi_xem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("thuc hien xem");
                KienNghi kn= bang.getSelectionModel().getSelectedItem();
                System.out.println(UserHomeController.password);
                UserHomeController uhc = new UserHomeController();
                try {
                    uhc.change_Bphu("UserFXML/xemkn.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        contextMenu.getItems().add(mi_xem);

        mi_sua = new MenuItem("Sua");
        mi_sua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                KienNghi kn= bang.getSelectionModel().getSelectedItem();

            }
        });
        contextMenu.getItems().add(mi_sua);

        mi_xoa = new MenuItem("Xoa");
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn= bang.getSelectionModel().getSelectedItem();

            }
        });
        contextMenu.getItems().add(mi_xoa);

        bang.setRowFactory(new Callback<TableView<KienNghi>, TableRow<KienNghi>>() {
            @Override
            public TableRow<KienNghi> call(TableView<KienNghi> param) {
                final TableRow<KienNghi> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(event.getButton() == MouseButton.SECONDARY && !row.isEmpty()){
                            contextMenu.show(bang,event.getScreenX(),event.getScreenY());
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
