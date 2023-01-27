package com.example.projectquanlikiennghi.controller.controllerUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class xemknController {
    @FXML
    private Button back_button;

    @FXML
    private Label l_label;

    @FXML
    private Label mkn_label;

    @FXML
    private Label nd_label;

    @FXML
    private Label ndph_label;

    @FXML
    private Label ng_label;

    @FXML
    private Label nph_label;

    @FXML
    private Label stt_label;

    @FXML
    private Label tt_label;

    @FXML
    void quay_lai(ActionEvent event) throws IOException {
        UserHomeController uhc = new UserHomeController();
        uhc.change_Bphu("UserFXML/DSKiennghiUser.fxml");
    }
}
