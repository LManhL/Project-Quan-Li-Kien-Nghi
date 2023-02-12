package com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKienNghi;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminMainController;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class XemKienNghiController implements Initializable {

    @FXML
    private Button button_back;

    @FXML
    private TextField coquanphanhoi;

    @FXML
    private TextField maKN;

    @FXML
    private TextField ngaygui;

    @FXML
    private TextField ngayphanhoi;

    @FXML
    private TextField nguoigui;

    @FXML
    private TextArea noidung;

    @FXML
    private TextArea phanhoi;

    @FXML
    private TextField stt;

    @FXML
    private TextField trangthai;
    @FXML
    private TextField sophananh;
    @FXML
    private ImageView back_buttonimg;

    private JdbcDAO repo = new JdbcDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void set_inf(KienNghi kn) throws SQLException {
        String s8 = String.valueOf(kn.getTrangthai());
        String name = repo.findUsernameByKN(kn.getMa_kien_nghi());
        Integer Countsophananh=1;
        List<KienNghi> listKienNghiGop=repo.getKienNghiGop(kn);
        Countsophananh+=listKienNghiGop.size();
        for(KienNghi value: listKienNghiGop){
            name+=" , "+repo.findUsernameByKN(value.getMa_kien_nghi());
        }
        nguoigui.setText(name);
        stt.setText("1");
        maKN.setText(kn.getMa_kien_nghi());
        //nguoigui.setText();
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
        trangthai.setText(s8);
        phanhoi.setText(kn.getNoidungphanhoi());
        ngayphanhoi.setText(kn.getNgayphanhoi());
        String cqph = repo.findCoquanByKN(kn.getMa_kien_nghi());
        coquanphanhoi.setText(cqph);
        sophananh.setText(String.valueOf(Countsophananh));
    }


    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/QuanLyKN/DSKiennghi.fxml"));
        Parent p = loader.load();

        AdminMainController.global_pane.setCenter(p);
    }

}
