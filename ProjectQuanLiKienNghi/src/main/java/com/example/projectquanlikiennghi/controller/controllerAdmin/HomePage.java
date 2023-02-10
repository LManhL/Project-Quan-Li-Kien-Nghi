package com.example.projectquanlikiennghi.controller.controllerAdmin;


import com.example.projectquanlikiennghi.JdbcDAO;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.SQLException;

// Quan ly trang chu
public class HomePage {
    @FXML
    private Text tongSoUser ;
    @FXML
    private Text tongSoKN;
    @FXML
    private Text KNchuaPheDuyet;
    @FXML
    private Text KNdaPheDuyet;

    private int tongUser ;
    private int tongKN ;
    private int KNchuaPD;
    private int KNdaPD ;

    private JdbcDAO repo = new JdbcDAO();

//    public HomePage(BorderPane borderPane) {
//
//        this.tongSoUser.setText(String.valueOf(tongUser));
//        this.tongSoKN.setText(String.valueOf(tongKN));
//        this.KNchuaPheDuyet.setText(String.valueOf(KNchuaPD));
//        this.KNdaPheDuyet.setText(String.valueOf(KNdaPD));
//    }

    public HomePage() {
        this.tongUser = 0;
        this.tongKN = 0;
        this.KNchuaPD = 0;
        this.KNdaPD = 0;
    }

    // load co so du lieu de thong ke
    public void loadStatistic() throws SQLException {
        this.tongUser = repo.count_user();
        this.tongKN = repo.count_KN();
        this.KNchuaPD = repo.count_KN_chuaPD();
        this.KNdaPD = repo.count_KN_daPD();
    }

    // dieu chinh text
    public void statistic() throws SQLException {
        loadStatistic();
        tongSoUser.setText(String.valueOf(tongUser));
        tongSoKN.setText(String.valueOf(tongKN));
        KNchuaPheDuyet.setText(String.valueOf(KNchuaPD));
        KNdaPheDuyet.setText(String.valueOf(KNdaPD));
    }



}
