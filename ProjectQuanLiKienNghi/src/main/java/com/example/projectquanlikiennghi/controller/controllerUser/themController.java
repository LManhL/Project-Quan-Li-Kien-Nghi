package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class themController implements Initializable {
    @FXML
    private TextField noi_dung;

    @FXML
    private ChoiceBox<String> the_loai;

    @FXML
    void cancle_kn(ActionEvent event) throws IOException {
        UserHomeController uhc  = new UserHomeController();
        uhc.change_Bphu("UserFXML/DSKiennghiUser.fxml");
    }

    @FXML
    void creat_kn(ActionEvent event) throws SQLException, IOException {

        Boolean check_nd = false, check_theloai = true;
        String ma_kn = null;
        int duoc_chon = the_loai.getSelectionModel().getSelectedIndex();
        int so_kn;
        JdbcDAO repo = new JdbcDAO();
        try {
             so_kn  = repo.count_KN() +1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        switch (duoc_chon) {
            case 1:
                ma_kn = "MT" + so_kn;
                break;
            case 2:
                ma_kn = "TC" + so_kn;
                break;
            case 3:
                ma_kn = "AN" + so_kn;
                break;
            case 4:
                ma_kn = "HC" + so_kn;
                break;
            case 5:
                ma_kn = "K" + so_kn;
                break;

            default:
                check_theloai = false;
                break;
        }
        if (noi_dung.getText()!=null){
            check_nd = true;
        }
        if(check_nd == false || check_theloai == false){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmation");
            alert.setHeaderText("Alert Information");
            alert.setContentText("thông tin chưa đầy đủ!!");
            alert.show();
        }
        LocalDate t = LocalDate.now();
        repo.add_kn_of_user(UserHomeController.username,UserHomeController.password,
                ma_kn,String.valueOf(t),noi_dung.getText(),the_loai.getValue());
        UserHomeController uhc  = new UserHomeController();
        uhc.change_Bphu("UserFXML/DSKiennghiUser.fxml");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] loai = {"môi trường","thi công", "an ninh","hộ chiếu","khác" };
        the_loai.getItems().addAll(loai);
    }
}
