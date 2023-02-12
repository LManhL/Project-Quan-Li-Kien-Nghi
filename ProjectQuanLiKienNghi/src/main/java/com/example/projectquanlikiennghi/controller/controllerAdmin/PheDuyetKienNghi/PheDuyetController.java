package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKienNghi;


import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminMainController;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class PheDuyetController {
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
    JdbcDAO repo = new JdbcDAO();
    KienNghi kienNghi;
    public void loadKN(KienNghi KN){
        MaKN.setText(KN.getMa_kien_nghi());
        Ngaygui.setText(KN.getNgaygui());
        Noidung.setText(KN.getNoidung());

        this.kienNghi = KN;
    }
    public void accept(ActionEvent e) throws IOException, SQLException {
        /*repo.updateStatus(kienNghi,2);

        buttonAccept.setVisible(false);
        buttonDecline.setVisible(false);
        status.setText("Kiến nghị đã được phê duyệt");
        status.setVisible(true);

        repo.themKN_Coquan(kienNghi.getMa_kien_nghi(), maCQ);*/
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/ChapNhanPheDuyet.fxml"));
        Parent p = loader.load();
        ChapNhanPheDuyetController controller = loader.getController();
        controller.set_inf(kienNghi);
        AdminMainController.global_pane.setCenter(p);

    }

    public void decline(ActionEvent e) throws IOException, SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setContentText("Bạn chắc chắn muốn từ chối kiến nghị chứ?");

        ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes){
            repo.updateStatus(kienNghi,1);

            buttonAccept.setVisible(false);
            buttonDecline.setVisible(false);
            status.setText("Kiến nghị bị từ chối");
            status.setVisible(true);
        }
        else if(result.get()==buttonTypeNo){
            //do nothing
        }
    }
}
