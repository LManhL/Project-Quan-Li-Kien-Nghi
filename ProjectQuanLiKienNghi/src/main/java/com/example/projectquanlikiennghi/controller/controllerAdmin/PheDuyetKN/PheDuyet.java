package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;


import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PheDuyet implements Initializable {
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

    @FXML
    MenuButton menu;
    @FXML
    private MenuItem cq1;

    @FXML
    private MenuItem cq2;

    @FXML
    private MenuItem cq3;

    @FXML
    private MenuItem cq4;

    @FXML
    private MenuItem cq5;

    @FXML
    private MenuItem cq6;

    @FXML
    private MenuItem cq7;

    @FXML
    private MenuItem cq8;

    @FXML
    private MenuItem cq9;

    @FXML
    private MenuItem cq10;

    @FXML
    private MenuItem cq11;

    @FXML
    private MenuItem cq12;

    @FXML
    private MenuItem cq13;
    JdbcDAO repo = new JdbcDAO();
    KienNghi kienNghi;
    private String maCQ;
    public void loadKN(KienNghi KN){
        MaKN.setText(KN.getMa_kien_nghi());
        Ngaygui.setText(KN.getNgaygui());
        Noidung.setText(KN.getNoidung());

        this.kienNghi = KN;
    }
    public void accept(ActionEvent e) throws IOException, SQLException {
        repo.updateStatus(kienNghi,2);

        buttonAccept.setVisible(false);
        buttonDecline.setVisible(false);
        status.setText("Kiến nghị đã được phê duyệt");
        status.setVisible(true);

        repo.themKN_Coquan(kienNghi.getMa_kien_nghi(), maCQ);
    }

    public void decline(ActionEvent e) throws IOException, SQLException {
        repo.updateStatus(kienNghi,1);

        buttonAccept.setVisible(false);
        buttonDecline.setVisible(false);
        status.setText("Kiến nghị bị từ chối");
        status.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cq1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq1.getText());
                maCQ = "BXDHM";
            }
        });
        cq2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq2.getText());
                maCQ = "CAHM";
            }
        });
        cq3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq3.getText());
                maCQ = "CAPTMM";
            }
        });
        cq4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq4.getText());
                maCQ = "CATL";
            }
        });
        cq5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq5.getText());
                maCQ = "CATPHN";
            }
        });
        cq6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq6.getText());
                maCQ = "QLTTNANN";
            }
        });
        cq7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq7.getText());
                maCQ = "STTTTHN";
            }
        });
        cq8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq8.getText());
                maCQ = "TATDP";
            }
        });
        cq9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq9.getText());
                maCQ = "TNMT";
            }
        });
        cq10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq10.getText());
                maCQ = "TNMTHM";
            }
        });
        cq11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq11.getText());
                maCQ = "TVS1";
            }
        });
        cq12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq12.getText());
                maCQ = "UBNDHM";
            }
        });
        cq13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq13.getText());
                maCQ = "UBNDPHM";
            }
        });
    }
}
