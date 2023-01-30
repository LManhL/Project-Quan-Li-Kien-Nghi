package com.example.projectquanlikiennghi.controller.controllerUser;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class changeUserInformationController {
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancle;
    @FXML
    void Confirm(ActionEvent event) throws SQLException, IOException {
        String Address = txtAddress.getText().toString();
        String SDT = txtPhoneNumber.getText().toString().replaceAll("\\s", "");;
        if(Address.isEmpty() || SDT.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Chưa nhập đủ thông tin");
            alert.show();
            return;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận thay đổi");
            alert.setContentText("Bạn đã chắc chắn muốn thay đổi với thông tin vừa nhập chứ?");

            ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeYes) {
                // Thay doi thong tin
                JdbcDAO repo = new JdbcDAO();
                repo.changeUserInformationForUser(UserHomeController.username, Address, SDT);
                UserHomeController uhc = new UserHomeController();
                uhc.change_Bphu("UserFXML/userInformation.fxml");
            } else if (result.get().getButtonData() == ButtonBar.ButtonData.NO) {
                // do nothing
            }
        }
    }
    @FXML
    void Cancle(ActionEvent event) throws IOException {
        UserHomeController uhc = new UserHomeController();
        uhc.change_Bphu("UserFXML/userInformation.fxml");
    }
    public void initialValue() throws SQLException {
        JdbcDAO repo=new JdbcDAO();
        Account account = repo.getUserInformationForChange(UserHomeController.username);
        txtAddress.setText(account.getDiachi());
        txtPhoneNumber.setText(account.getSDT());
    }
}
