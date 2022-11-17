package com.example.projectquanlikiennghi.controller.controllerLogin;

import com.example.projectquanlikiennghi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLoginUser {
    @FXML
    private Button buttonLogout;
    public void userLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
}
