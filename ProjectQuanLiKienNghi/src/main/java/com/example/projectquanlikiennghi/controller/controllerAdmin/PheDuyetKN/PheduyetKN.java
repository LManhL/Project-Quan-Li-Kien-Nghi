package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;

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

public class PheduyetKN implements Initializable {
    @FXML
    private ScrollPane scrollPane;

    JdbcDAO repo = new JdbcDAO();

    ObservableList<KienNghi> listKN = FXCollections.observableArrayList();

    public PheduyetKN (){
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void load_KN_chuaPD() throws SQLException, IOException {
        Main main = new Main();

        listKN = repo.listKN_chuaPD();
        VBox vb = new VBox();
        for (int i=0; i< listKN.size(); i++){
            FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/PheDuyetKN/Pheduyet.fxml"));
            Parent pr = loader.load();
            vb.getChildren().add(pr);

            PheDuyet pdKN = (PheDuyet) loader.getController();
            pdKN.loadKN(listKN.get(i));

        }


        scrollPane.setContent(vb);
    }


}
