package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKienNghi;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminMainController;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class DSKienNghiController implements Initializable {


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
    private TableColumn<KienNghi, String> Trangthai = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Noidungphanhoi = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Ngayphanhoi = new TableColumn<>();
    @FXML
    private TableColumn<KienNghi, String> Loai = new TableColumn<>();
    @FXML
    private TextField filterField = new TextField();

    private JdbcDAO repo = new JdbcDAO();

    private ObservableList<KienNghi> listKN = FXCollections.observableArrayList();


    private ContextMenu contextMenu;
    private MenuItem mi_xem;
    private MenuItem mi_sua;
    private MenuItem mi_xoa;
    private MenuItem mi_phan_hoi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       STT.setCellValueFactory( new PropertyValueFactory<KienNghi, Integer>("STT"));
       Ma_kien_nghi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ma_kien_nghi"));
       Ngaygui.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ngaygui"));
       Noidung.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Noidung"));
       Trangthai.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Trangthai"));
       Noidungphanhoi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Noidungphanhoi"));
       Ngayphanhoi.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Ngayphanhoi"));
       Loai.setCellValueFactory( new PropertyValueFactory<KienNghi, String>("Loai"));

        try {
            listKN = repo.listKN();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        FilteredList<KienNghi> filteredData = new FilteredList<>(listKN,b->true);

        filterField.textProperty().addListener((observable,oldValue,newValue)->{
            filteredData.setPredicate(kienNghi -> {
                if(newValue==null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(kienNghi.getMa_kien_nghi().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(kienNghi.getLoai().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(kienNghi.getNgaygui().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(kienNghi.getNoidung().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(kienNghi.getNoidungphanhoi().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(kienNghi.getNgayphanhoi().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else
                    return false;
            });
        });

        SortedList<KienNghi> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
       //table.getColumns().addAll(STT,Hovaten,SDT,Diachi,Gioitinh,Namsinh,CCCD,Username,SoKN );


        contextMenu = new ContextMenu();

        mi_xem = new MenuItem("Xem");
        mi_xem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/XemInfoKN.fxml"));
                    Parent p = loader.load();
                    XemKienNghiController knc = loader.getController();
                    knc.set_inf(kn);
                    AdminMainController.global_pane.setCenter(p);


                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xem);

        mi_sua = new MenuItem("Sửa");
        mi_sua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/SuaInfoKN.fxml"));
                    Parent p = loader.load();
                    SuaKiennghiController knc = loader.getController();
                    knc.set_inf(kn);
                    AdminMainController.global_pane.setCenter(p);


                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_sua);


        mi_xoa = new MenuItem("Xóa");
        mi_xoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws RuntimeException {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Xác nhận thêm");
                    alert.setContentText("Bạn đã chắc chắn muốn xóa chứ?");

                    ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
                    ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == buttonTypeYes){
                        repo.delete_kn(kn.getMa_kien_nghi());
                        System.out.println("xoa kn thanh cong");

                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/DSKienNghi.fxml"));
                        Parent p = loader.load();

                        AdminMainController.global_pane.setCenter(p);
                    }
                    else{
                        // do nothing
                    }
                } catch (SQLException | IOException e) {
                    System.out.println("xoa kn that bai");
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_xoa);
        mi_phan_hoi = new MenuItem("Phản hồi");
        mi_phan_hoi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                KienNghi kn = table.getSelectionModel().getSelectedItem();
                try {
                    boolean check=false;
                    if(kn.getTrangthai()==2) check=true;
                    if(check){
                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/PhanHoiKienNghi.fxml"));
                        Parent p = loader.load();
                        PhanHoiKienNghiController controller = loader.getController();
                        controller.set_inf(kn);
                        AdminMainController.global_pane.setCenter(p);
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Lỗi");
                        if(kn.getTrangthai()==0){
                            alert.setContentText("Kiến nghị chưa được phê duyệt");
                        }
                        else if(kn.getTrangthai()==1){
                            alert.setContentText("Kiến nghị đã bị từ chối phê duyệt");
                        }
                        else if(kn.getTrangthai()==3){
                            alert.setContentText("Kiến nghị đã được phản hồi");
                        }
                        alert.show();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        contextMenu.getItems().add(mi_phan_hoi);

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
