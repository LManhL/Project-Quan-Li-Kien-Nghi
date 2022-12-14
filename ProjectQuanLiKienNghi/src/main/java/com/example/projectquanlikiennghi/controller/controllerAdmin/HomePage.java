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

    private int tongUser = 10;
    private int tongKN = 2408;
    private int KNchuaPD = 7567;
    private int KNdaPD = 45435;

    JdbcDAO repo = new JdbcDAO();

//    public HomePage(BorderPane borderPane) {
//
//        this.tongSoUser.setText(String.valueOf(tongUser));
//        this.tongSoKN.setText(String.valueOf(tongKN));
//        this.KNchuaPheDuyet.setText(String.valueOf(KNchuaPD));
//        this.KNdaPheDuyet.setText(String.valueOf(KNdaPD));
//    }

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
