package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ThemKienNghiController implements Initializable {
    @FXML
    private TextArea noi_dung;

    @FXML
    private ChoiceBox<String> the_loai;

    @FXML
    void cancle_kn(ActionEvent event) throws IOException {
        UserHomeController uhc  = new UserHomeController();
        uhc.change_Bphu("UserFXML/DSKiennghiUser.fxml");
    }

    final ArrayList<Integer> listNumber = new ArrayList<Integer>();
    public ThemKienNghiController(){
        for(int i=1;i<=100;i++){
            listNumber.add(i);
        }
    }

    @FXML
    void creat_kn(ActionEvent event) throws SQLException, IOException {

        Boolean check_nd = false, check_theloai = true;
        String ma_kn = null;
        int duoc_chon = the_loai.getSelectionModel().getSelectedIndex();
        JdbcDAO repo = new JdbcDAO();
        Collections.shuffle(listNumber);
        String randomNumber=String.valueOf(listNumber.get(0))+String.valueOf(listNumber.get(1))+String.valueOf(listNumber.get(2));
        switch (duoc_chon) {
            case 1:
                ma_kn = "MT" + randomNumber;
                break;
            case 2:
                ma_kn = "TC" + randomNumber;
                break;
            case 3:
                ma_kn = "AN" + randomNumber;
                break;
            case 4:
                ma_kn = "HC" + randomNumber;
                break;
            case 5:
                ma_kn = "K" + randomNumber;
                break;

            default:
                check_theloai = false;
                break;
        }
        if (!noi_dung.getText().toString().isEmpty()){
            check_nd = true;
        }
        if(check_nd == false || check_theloai == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Thông tin chưa đầy đủ");
            alert.show();
        }
        else{
            if(noi_dung.getText().toString().length()<=50){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Vui lòng nhập nội dung chi tiết hơn 50 ký tự");
                alert.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Xác nhận thêm");
                alert.setContentText("Bạn đã chắc chắn với thông tin vừa nhập chứ?");

                ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
                ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == buttonTypeYes){
                    LocalDate t = LocalDate.now();
                    repo.add_kn_of_user(UserHomeController.username,UserHomeController.password,
                            ma_kn,String.valueOf(t),noi_dung.getText(),the_loai.getValue());
                    UserHomeController uhc  = new UserHomeController();
                    uhc.change_Bphu("UserFXML/DSKiennghiUser.fxml");
                }
                else{
                    // do nothing
                }
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] loai = {"Môi trường","Thi công", "An ninh","Hộ chiếu","Khác" };
        the_loai.getItems().addAll(loai);
    }
}
