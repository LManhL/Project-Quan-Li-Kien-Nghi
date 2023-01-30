package com.example.projectquanlikiennghi.controller.controllerUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class XemKienNghiUserController implements Initializable {
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
    void set_inf(String s1, String s2, String s3,String s4,String s5,String s6,String s7,String s8){
        l_label.setText(s1);
        mkn_label.setText(s2);
        nd_label.setText(s3);
        ndph_label.setText(s4);
        ng_label.setText(s5);
        nph_label.setText(s6);
        stt_label.setText(s7);

        if(s8.equals("0")){
            s8="Chưa phê duyệt";
        }
        else if(s8.equals("1")){
            s8="Từ chối phê duyệt";
        }
        else if(s8.equals("2")){
            s8="Đã phê duyệt chưa có phản hồi";
        }
        else if(s8.equals("3")){
            s8="Đã phản hồi";
        }
        else;
        tt_label.setText(s8);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
