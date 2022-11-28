package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLoginUser {
    @FXML
    private Button buttonLogout;
    @FXML
    private BorderPane Bpane_phu;

    public void userLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }


    @FXML
    void userInformation(ActionEvent event) {
        Parent p = new FXMLLoader().load(getClass().getResource("information_user.fxml"));
        Bpane_phu.setCenter(p);
    }

    @FXML
    void userList(ActionEvent event) {
        Parent p = new FXMLLoader().load(getClass().getResource("danh_sach_ykien_user.fxml"));
        Bpane_phu.setCenter(p);
    }

}
