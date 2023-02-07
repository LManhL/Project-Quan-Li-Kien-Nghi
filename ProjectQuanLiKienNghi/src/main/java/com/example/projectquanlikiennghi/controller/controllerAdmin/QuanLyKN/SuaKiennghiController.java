package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKN;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.Account;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SuaKiennghiController implements Initializable {

    @FXML
    private ImageView back_buttonimg;

    @FXML
    private Button button_back;

    @FXML
    private Button change;

    @FXML
    private Label coquanphanhoi;

    @FXML
    private Label maKN;

    @FXML
    private TextField ngaygui;

    @FXML
    private TextField ngayphanhoi;

    @FXML
    private Label nguoigui;

    @FXML
    private TextArea noidung;

    @FXML
    private TextArea phanhoi;

    @FXML
    private Label status;

    @FXML
    private Label stt;

    @FXML
    private Label trangthai;

    private JdbcDAO repo = new JdbcDAO();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void set_inf(KienNghi kn) throws SQLException {
        String s8 = String.valueOf(kn.getTrangthai());

        String name = repo.findUsernameByKN(kn.getMa_kien_nghi());
        nguoigui.setText(name);
        stt.setText("1");
        maKN.setText(kn.getMa_kien_nghi());
        ngaygui.setText(kn.getNgaygui());
        noidung.setText(kn.getNoidung());
        if(s8.equals("0")){
            s8="Chưa phê duyệt";
        }
        else if(s8.equals("1")){
            s8="Từ chối phê duyệt";
        }
        else if(s8.equals("2")){
            s8="Đã phê duyệt chưa có phản hồi";
        }
        else if(s8.equals("3")){
            s8="Đã phản hồi";
        }
        else;
        trangthai.setText(s8);
        phanhoi.setText(kn.getNoidungphanhoi());
        ngayphanhoi.setText(kn.getNgayphanhoi());

        String cqph = repo.findCoquanByKN(kn.getMa_kien_nghi());
        coquanphanhoi.setText(cqph);
    }

    public void buttonChange() throws SQLException {
        String send_date = ngaygui.getText();
        String content = noidung.getText();
        String feedback = phanhoi.getText();
        String feeddate = ngayphanhoi.getText();

        repo.AdminchangeKNINF(send_date, content, feedback, feeddate, maKN.getText());
        status.setText("Cập nhật thành công");
        status.setVisible(true);
        change.setVisible(false);

    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/DSKiennghi.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);
    }

}