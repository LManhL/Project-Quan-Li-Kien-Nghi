package com.example.projectquanlikiennghi.controller.controllerAdmin.PhanHoiKN;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PhanhoiKN implements Initializable {
    @FXML
    private ScrollPane scrollPane;

    JdbcDAO repo = new JdbcDAO();

    ObservableList<KienNghi> listPH = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Main main = new Main();

        // load kien nghi da phe duyet
        try {
            listPH = repo.listKN_daPD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        VBox vb = new VBox();
        for (int i=0; i< listPH.size(); i++){
            FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/PhanHoiKN/PhanHoi.fxml"));
            Parent pr = null;

            // load PhanHoi
            try {
                pr = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            vb.getChildren().add(pr);

            PhanHoi phKN = (PhanHoi) loader.getController();
            phKN.loadPhanHoi(listPH.get(i));

        }
        scrollPane.setContent(vb);

    }
}
