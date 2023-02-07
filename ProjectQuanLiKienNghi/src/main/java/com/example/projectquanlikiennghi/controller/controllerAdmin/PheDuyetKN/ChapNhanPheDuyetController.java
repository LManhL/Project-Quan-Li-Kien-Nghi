package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;

import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class ChapNhanPheDuyetController {
    @FXML
    private Button btnThietLapThongTin;
    @FXML
    private Button btnGopKienNghi;
    @FXML
    private Button btnCancle;
    private KienNghi kienNghi;

    public void ThietLapThongTin(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/ThietLapThongTin.fxml"));
        Parent p = loader.load();
        ThietLapThongTinController controller = loader.getController();
        controller.set_inf(kienNghi);
        AdminHomeController.global_pane.setCenter(p);
    }
    public void GopKienNghi(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/GopKienNghi.fxml"));
        Parent p = loader.load();
        GopKienNghiController controller=loader.getController();
        controller.set_inf(kienNghi);
        AdminHomeController.global_pane.setCenter(p);
    }
    public void Cancle(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/PheDuyetKN.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);
    }
    public void set_inf(KienNghi kn){
        this.kienNghi=kn;
    }
}
