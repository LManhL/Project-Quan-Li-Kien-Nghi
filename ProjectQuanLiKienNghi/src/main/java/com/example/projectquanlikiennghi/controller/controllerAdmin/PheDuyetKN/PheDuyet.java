package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;


import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;

public class PheDuyet {
    @FXML
    TextArea MaKN;
    @FXML
    TextArea Ngaygui;
    @FXML
    TextArea Noidung;
    @FXML
    Button buttonAccept;
    @FXML
    Button buttonDecline;
    @FXML
    Label status;

    JdbcDAO repo = new JdbcDAO();
    KienNghi kienNghi;
    public void loadKN(KienNghi KN){
        MaKN.setText(KN.getMa_kien_nghi());
        Ngaygui.setText(KN.getNgaygui());
        Noidung.setText(KN.getNoidung());

        this.kienNghi = KN;
    }
    public void accept(ActionEvent e) throws IOException, SQLException {
        repo.updateStatus(kienNghi,1);

        buttonAccept.setVisible(false);
        buttonDecline.setVisible(false);
        status.setText("Kiến nghị đã được phê duyệt");
        status.setVisible(true);
    }

    public void decline(ActionEvent e) throws IOException, SQLException {
        repo.updateStatus(kienNghi,0);

        buttonAccept.setVisible(false);
        buttonDecline.setVisible(false);
        status.setText("Kiến nghị bị từ chối");
        status.setVisible(true);
    }
}
