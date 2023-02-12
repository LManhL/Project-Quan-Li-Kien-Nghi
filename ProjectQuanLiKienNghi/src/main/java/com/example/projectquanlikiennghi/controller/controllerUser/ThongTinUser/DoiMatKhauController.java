package com.example.projectquanlikiennghi.controller.controllerUser.ThongTinUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.controller.controllerUser.UserMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class DoiMatKhauController {
    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancle;
    @FXML
    private Label labelOldPassword;
    @FXML
    private Label labelNewPassword;
    @FXML
    void confirmPassword (ActionEvent event) throws SQLException, IOException {
        String oldPass = oldPassword.getText().toString();
        String newPass = newPassword.getText().toString();
        if(oldPass.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Chưa nhập mật khẩu cũ");
            alert.show();
            return;
        }
        if(oldPass.equals(UserMainController.password)){
            if(newPass.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Chưa nhập mật khẩu mới");
                alert.show();
            }
            else{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Xác nhận thay đổi");
                alert.setContentText("Bạn đã chắc chắn muốn thay đổi với thông tin vừa nhập chứ?");

                ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
                ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == buttonTypeYes){
                    // Thay doi mat khau
                    JdbcDAO repo = new JdbcDAO();
                    repo.changePassword(UserMainController.username,newPass);
                    UserMainController uhc = new UserMainController();
                    uhc.change_Bphu("UserFXML/userInformation.fxml");
                }
                else if(result.get()==buttonTypeNo){
                    //do nothing
                }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Mật khẩu cũ nhập sai");
            alert.show();
        }
    }
    @FXML
    void cancle(ActionEvent event) throws IOException {
        UserMainController uhc = new UserMainController();
        uhc.change_Bphu("UserFXML/userInformation.fxml");
    }

}
