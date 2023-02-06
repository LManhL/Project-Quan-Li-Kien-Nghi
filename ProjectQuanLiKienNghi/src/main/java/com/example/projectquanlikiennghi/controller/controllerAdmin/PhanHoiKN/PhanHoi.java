package com.example.projectquanlikiennghi.controller.controllerAdmin.PhanHoiKN;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;

public class PhanHoi {
    @FXML
    private TextArea MaKN;
    @FXML
    private TextArea Ngaygui;
    @FXML
    private TextArea Noidung;
    @FXML
    private TextArea Ngayphanhoi;
    @FXML
    private TextArea Noidungphanhoi;
    @FXML
    private TextArea CQPH;
    @FXML
    private Button buttonSend;
    @FXML
    Label status;

    JdbcDAO repo = new JdbcDAO();

    KienNghi kienNghi;

    public void loadPhanHoi(KienNghi KN){
        MaKN.setText(KN.getMa_kien_nghi());
        Ngaygui.setText(KN.getNgaygui());
        Noidung.setText(KN.getNoidung());

        this.kienNghi = KN;
    }

    public void guiPhanhoi(ActionEvent e)throws IOException, SQLException {
        String ngayPH = Ngayphanhoi.getText();
        String ndph = Noidungphanhoi.getText();

        repo.updatePhanHoi(kienNghi, ngayPH, ndph);
        repo.updateStatus(kienNghi,3);
        buttonSend.setVisible(false);
        status.setText("Phản hồi kiến nghị thành công");
        status.setVisible(true);
    }


}
