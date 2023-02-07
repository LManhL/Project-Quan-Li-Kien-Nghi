package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.controller.controllerUser.userInformationController;
import com.example.projectquanlikiennghi.models.Account;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

public class DSUser implements Initializable {

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
    @FXML
    Button buttonAddUser = new Button();
    @FXML
    TextField filterField;

    JdbcDAO repo = new JdbcDAO();

    ObservableList<Account> list = FXCollections.observableArrayList();

    private ContextMenu contextMenu;
    private MenuItem mi_xem;
    private MenuItem mi_sua;

    private MenuItem mi_xoa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        STT.setCellValueFactory( new PropertyValueFactory<Account, Integer>("ID"));
        Hovaten.setCellValueFactory( new PropertyValueFactory<Account, String>("Hovaten"));
        SDT.setCellValueFactory( new PropertyValueFactory<Account, String>("SDT"));
        Diachi.setCellValueFactory( new PropertyValueFactory<Account, String>("Diachi"));
        Gioitinh.setCellValueFactory( new PropertyValueFactory<Account, String>("Gioitinh"));
        Namsinh.setCellValueFactory( new PropertyValueFactory<Account, String>("Namsinh"));
        CCCD.setCellValueFactory( new PropertyValueFactory<Account, String>("CCCD"));
        Username.setCellValueFactory( new PropertyValueFactory<Account, String>("Username"));
        SoKN.setCellValueFactory( new PropertyValueFactory<Account, Integer>("SoKN"));

        try {
            list = repo.listUser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        FilteredList<Account> filteredData = new FilteredList<>(list, b->true);

        filterField.textProperty().addListener((observable,oldValue,newValue)->{
            filteredData.setPredicate(account -> {
                if(newValue==null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(account.getCCCD().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getDiachi().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getUsername().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getNamsinh().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(String.valueOf(account.getSoKN()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getHovaten().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getGioitinh().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(account.getSDT().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else
                    return false;
            });
        });

        SortedList<Account> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
        //table.getColumns().addAll(STT,Hovaten,SDT,Diachi,Gioitinh,Namsinh,CCCD,Username,SoKN );


        contextMenu = new ContextMenu();

        mi_xem = new MenuItem("Xem");
        mi_xem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account acc= table.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/XemInfoUser.fxml"));
                    Parent p = loader.load();
                    XemInfoUser uc = loader.getController();
                    uc.set_inf(acc);
                    AdminHomeController.global_pane.setCenter(p);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xem);

        mi_sua = new MenuItem("Sửa");
        mi_sua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account acc= table.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/SuaInfoUser.fxml"));
                    Parent p = loader.load();
                    SuaInfoUserController uc = loader.getController();
                    uc.set_inf(acc);
                    AdminHomeController.global_pane.setCenter(p);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_sua);

        mi_xoa = new MenuItem("Xoa");
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws RuntimeException {
                Account acc= table.getSelectionModel().getSelectedItem();
                try {
                    repo.delete_user(acc.getCCCD());
                    System.out.println("xoa user thanh cong");
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
                    Parent p = loader.load();

                    AdminHomeController.global_pane.setCenter(p);


                } catch (SQLException | IOException e) {
                    System.out.println("xoa user that bai");
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xoa);

        table.setRowFactory(new Callback<TableView<Account>, TableRow<Account>>() {
            @Override
            public TableRow<Account> call(TableView<Account> param) {
                final TableRow<Account> row = new TableRow<>();
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

    public void themUser() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyUser/ThemUser.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);

    }

}
