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
import java.util.Optional;
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
    private TableColumn<KienNghi, String> trangthai_cot;

    public DSKiennghiUserController() {
    }

    @FXML
    void click_them(ActionEvent event) {
        UserHomeController uhc = new UserHomeController();
        try {
            uhc.change_Bphu("UserFXML/addKienNghi.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // tao thong tin khi click chuot phai
    private ContextMenu contextMenu;
    private MenuItem    mi_xem;
    private MenuItem    mi_xoa;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        id_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,Integer>("STT"));
        ngaygui_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("Ngaygui"));
        trangthai_cot.setCellValueFactory(new PropertyValueFactory<KienNghi,String>("Loai"));

        //lay kien nghi cua 1 ca nhan
        JdbcDAO repo = new JdbcDAO();
        ObservableList<KienNghi> listofuser = FXCollections.observableArrayList();
        try {
            listofuser = repo.getKienNghiuser(UserHomeController.username,UserHomeController.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(KienNghi kienNghi: listofuser){
            int trangThai = kienNghi.getTrangthai();
            if(trangThai==0){
                kienNghi.setLoai("Chưa phê duyệt");
            }
            else if(trangThai==1){
                kienNghi.setLoai("Từ chối phê duyệt");
            }
            else if(trangThai==2){
                kienNghi.setLoai("Đã phê duyệt chưa có phản hồi");
            }
            else if(trangThai==3){
                kienNghi.setLoai("Đã phản hồi");
            }
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
                UserHomeController uhc = new UserHomeController();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("UserFXML/showKienNghi.fxml"));
                    Parent p=loader.load();
                    XemKienNghiUserController xc = loader.getController();
                    xc.set_inf(kn.getLoai(), kn.getMa_kien_nghi(),kn.getNoidung(),kn.getNoidungphanhoi(),
                            kn.getNgaygui(),kn.getNgayphanhoi(),String.valueOf(kn.getSTT()),String.valueOf(kn.getTrangthai()));
                    UserHomeController.global_phu.setCenter(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        contextMenu.getItems().add(mi_xem);



        mi_xoa = new MenuItem("Xóa");
        ObservableList<KienNghi> finalListofuser = listofuser;
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = bang.getSelectionModel().getSelectedItem();
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Xác nhận xóa");
                    alert.setContentText("Bạn đã chắc chắn muốn xóa chứ?");

                    ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
                    ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == buttonTypeYes){
                        repo.delete_kn(kn.getMa_kien_nghi());
                        finalListofuser.remove(kn);
                        bang.setItems(finalListofuser);
                    }
                    else{
                        // do nothing
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

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
