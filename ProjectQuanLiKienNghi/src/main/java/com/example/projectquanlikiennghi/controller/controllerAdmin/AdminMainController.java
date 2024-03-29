package com.example.projectquanlikiennghi.controller.controllerAdmin;

import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKienNghi.PheduyetKienNghiController;
import com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKienNghi.DSKienNghiController;
import com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser.DSUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Gom cac button
public class AdminMainController implements Initializable  {

    @FXML
    public BorderPane borderPane;

    public static BorderPane global_pane;
    @FXML
    private Button buttonHome;
    @FXML
    private Button buttonUserList;
    @FXML
    private Button buttonKNList;
    @FXML
    private Button buttonPheduyetKN;
    @FXML
    private Button buttonPhanhoiKN;
    @FXML
    private Button buttonAddUser;

    @FXML
    private Button buttonLogout;


    private HomePageController hp ;
    public AdminMainController(){}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        global_pane = borderPane;
        Main main = new Main();
        FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/HomePage.fxml"));
        Parent pr = null;
        try {
            pr = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        borderPane.setCenter(pr);
        HomePageController hp = (HomePageController) loader.getController();
        try {
            hp.statistic();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void clear() {
        borderPane.setCenter(null);
    }


    public void adminLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        Main.globalState.setWidth(597);
        Main.globalState.setHeight(459);
        m.changeScene("LoginFXML/login.fxml");
    }

    public void adminHomeView(ActionEvent e) throws IOException, SQLException {
        Main main = new Main();
        FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/HomePage.fxml"));
        Parent pr = loader.load();
        borderPane.setCenter(pr);

        HomePageController hp = (HomePageController) loader.getController();
        hp.statistic();
    }
    public void userListView(ActionEvent e) throws IOException {
        Main main = new Main();
        FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/QuanLyUser/DSUser.fxml"));
        Parent pr = loader.load();
        borderPane.setCenter(pr);

        DSUserController dsUser = (DSUserController) loader.getController();
        //dsUser.loadUser();
    }
    public void KNView(ActionEvent e) throws IOException, SQLException {
        Main main = new Main();
    FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/QuanLyKN/DSKiennghi.fxml"));
        Parent pr = loader.load();
        borderPane.setCenter(pr);

        DSKienNghiController dsKN = (DSKienNghiController) loader.getController();
        //dsKN.loadKN();
    }
    public void pheduyetKNView(ActionEvent e) throws IOException, SQLException {
        Main main = new Main();
        FXMLLoader loader = new FXMLLoader(main.getClass().getResource("AdminFXML/PheDuyetKN/PheduyetKN.fxml"));
        Parent pr = loader.load();
        borderPane.setCenter(pr);

        PheduyetKienNghiController pdKN = (PheduyetKienNghiController) loader.getController();
        //pdKN.load_KN_chuaPD();
    }
}
