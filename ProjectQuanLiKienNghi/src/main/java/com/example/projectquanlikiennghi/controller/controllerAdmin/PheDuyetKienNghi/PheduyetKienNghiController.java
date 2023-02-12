package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKienNghi;

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
import java.util.List;
import java.util.ResourceBundle;

public class PheduyetKienNghiController implements Initializable {
    @FXML
    private ScrollPane scrollPane;

    private JdbcDAO repo = new JdbcDAO();

    private ObservableList<KienNghi> listKN = FXCollections.observableArrayList();

    public PheduyetKienNghiController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Main main = new Main();

        // load kien nghi chua phe duyet
        try {
            listKN = repo.listKN_chuaPD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        setItem(listKN);
    }

    public void setItem(List<KienNghi> list){
        Main main =new Main();
        VBox vb = new VBox();
        for (int i=0; i< list.size(); i++){
            FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/PheDuyetKN/Pheduyet.fxml"));
            Parent pr = null;

            // load PheDuyet
            try {
                pr = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            vb.getChildren().add(pr);

            PheDuyetController pdKN = (PheDuyetController) loader.getController();
            pdKN.loadKN(list.get(i));

        }
        scrollPane.setContent(vb);
    }
}
