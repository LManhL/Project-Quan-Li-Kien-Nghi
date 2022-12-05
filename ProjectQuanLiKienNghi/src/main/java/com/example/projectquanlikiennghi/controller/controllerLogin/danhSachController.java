package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.KienNghi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class danhSachController implements Initializable {
    @FXML
    private TableView<KienNghi> bang;

    @FXML
    private TableColumn<KienNghi, String> id_cot;

    @FXML
    private TableColumn<KienNghi, String> ngay_cot;

    @FXML
    private TableColumn<KienNghi, String> trangthai_cot;

    @FXML
    void click_them(ActionEvent event) {

    }
        // tao thong tin khi click chuot phai
    private ContextMenu contextMenu;
    private MenuItem    mi_xem;
    private MenuItem    mi_sua;
    private MenuItem    mi_xoa;

    ObservableList<KienNghi> ds_kien_nghi = FXCollections.observableArrayList(
            new KienNghi("1","123","123","2")
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        id_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("id"));
        ngay_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("ngay_gui"));
        trangthai_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("trang_thai"));

        bang.setItems(ds_kien_nghi);

        //gan su kien cho menuitem cua contextMenu
        contextMenu = new ContextMenu();
        mi_xem = new MenuItem("Xem");
        mi_xem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        contextMenu.getItems().add(mi_xem);

        mi_sua = new MenuItem("Sua");
        mi_sua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        contextMenu.getItems().add(mi_sua);

        mi_xoa = new MenuItem("Xoa");
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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
                        if(event.getButton() == MouseButton.SECONDARY){
                            contextMenu.show(bang,event.getScreenX(),event.getScreenY());
                        }
                    }
                });
                return row;
            }
        });

    }

}
