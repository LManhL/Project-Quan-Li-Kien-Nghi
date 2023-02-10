package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKN;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class PhanHoiKienNghiController {
    @FXML
    private TextArea NoiDungKienNghiText;
    @FXML
    private TextArea NoiDungPhanHoiText;
    @FXML
    private Button btCancle;
    @FXML
    private Button btConfirm;
    private KienNghi kiennghi;

    public void set_inf(KienNghi kn) {
        String noidung=kn.getNoidung();
        NoiDungKienNghiText.setText(noidung);
        kiennghi=kn;
    }
    public void Confirm(ActionEvent e) throws SQLException, IOException {
        JdbcDAO repo=new JdbcDAO();
        String phanhoi=NoiDungPhanHoiText.getText().toString();
        if(phanhoi.length()<=50){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Vui lòng nhập nội dung chi tiết hơn 50 ký tự");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận ");
            alert.setContentText("Bạn đã chắc chắn với thông tin vừa nhập chứ?");

            ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeYes){
                LocalDate t = LocalDate.now();
                repo.updatePhanHoi(kiennghi,String.valueOf(t),phanhoi);
                repo.updatePhanHoiKienNghiGop(kiennghi,String.valueOf(t),phanhoi);
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/DSKiennghi.fxml"));
                Parent p = loader.load();

                AdminHomeController.global_pane.setCenter(p);
            }
            else{
                // do nothing
            }
    }
    }
    public void Cancle(ActionEvent e) throws IOException {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/DSKiennghi.fxml"));
            Parent p = loader.load();

            AdminHomeController.global_pane.setCenter(p);
    }
}
