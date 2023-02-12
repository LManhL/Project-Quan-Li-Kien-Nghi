package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKienNghi;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminMainController;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class GopKienNghiController implements Initializable {
    @FXML
    private TextField MaKienNghiText;
    @FXML
    private Button btnXem;
    @FXML
    private TextArea NoiDungText;
    @FXML
    private Button btnGop;
    @FXML
    private TextField TheLoaiText;
    @FXML
    private Button btnHuy;
    @FXML
    private Label lbNoiDung;
    @FXML
    private Label lbTheLoai;

    private KienNghi kienNghi;
    private boolean check;

    public void set_inf(KienNghi kn) {
        this.kienNghi=kn;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NoiDungText.setVisible(false);
        lbNoiDung.setVisible(false);
        lbTheLoai.setVisible(false);
        TheLoaiText.setVisible(false);
        check=false;
    }
    public void Xem(ActionEvent e) throws SQLException {
        String maKienNghi=MaKienNghiText.getText().toString();
        JdbcDAO repo=new JdbcDAO();

        KienNghi KN=repo.getKienNghi(maKienNghi);

        if(KN!=null){
            NoiDungText.setVisible(true);
            lbNoiDung.setVisible(true);
            lbTheLoai.setVisible(true);
            TheLoaiText.setVisible(true);
            NoiDungText.setText(KN.getNoidung());
            TheLoaiText.setText(KN.getLoai());
            check=true;
        }
        else{
            check=false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Không tồn tại mã kiến nghị tương ứng");
            alert.show();
            NoiDungText.setVisible(false);
            lbNoiDung.setVisible(false);
            lbTheLoai.setVisible(false);
            TheLoaiText.setVisible(false);
        }

    }
    public void Huy(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/ChapNhanPheDuyet.fxml"));
        Parent p = loader.load();

        AdminMainController.global_pane.setCenter(p);
    }
    public void Gop(ActionEvent e) throws SQLException, IOException {
        if(check){
            String maKienNghi=MaKienNghiText.getText().toString();
            JdbcDAO repo=new JdbcDAO();
            KienNghi KN=repo.getKienNghi(maKienNghi);
            if(maKienNghi.equals(kienNghi.getMa_kien_nghi())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Không thể gộp kiến nghị với chính nó");
                alert.show();
                return;
            }
            if(KN.getTrangthai()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Không thể gộp với kiến nghị chưa được phê duyệt");
                alert.show();
                return;
            }
            else if(KN.getTrangthai()==1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Không thể gộp với kiến nghị bị từ chối phê duyệt");
                alert.show();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xác nhận ");
            alert.setContentText("Bạn chắc chắn muốn gộp kiến nghị chứ?");

            ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == buttonTypeYes){
                repo.GopKienNghiQuery(MaKienNghiText.getText().toString(),kienNghi.getMa_kien_nghi());
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/PheDuyetKN.fxml"));
                Parent p = loader.load();

                AdminMainController.global_pane.setCenter(p);
            }
            else if(result.get()==buttonTypeNo){
                //do nothing
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Không thể gộp do không tồn tại mã kiến nghị tương ứng");
            alert.show();
        }
    }
}
