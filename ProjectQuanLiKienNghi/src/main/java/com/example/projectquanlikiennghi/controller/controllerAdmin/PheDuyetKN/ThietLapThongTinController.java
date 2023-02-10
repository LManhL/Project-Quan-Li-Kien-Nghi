package com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;

import com.example.projectquanlikiennghi.JdbcDAO;
import com.example.projectquanlikiennghi.Main;
import com.example.projectquanlikiennghi.controller.controllerAdmin.AdminHomeController;
import com.example.projectquanlikiennghi.models.CoQuanPhanHoi;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class ThietLapThongTinController implements Initializable {
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancle;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem cq1;

    @FXML
    private MenuItem cq2;

    @FXML
    private MenuItem cq3;

    @FXML
    private MenuItem cq4;

    @FXML
    private MenuItem cq5;

    @FXML
    private MenuItem cq6;

    @FXML
    private MenuItem cq7;

    @FXML
    private MenuItem cq8;

    @FXML
    private MenuItem cq9;

    @FXML
    private MenuItem cq10;

    @FXML
    private MenuItem cq11;

    @FXML
    private MenuItem cq12;

    @FXML
    private MenuItem cq13;
    @FXML
    private Label lbdiachi;
    @FXML
    private Label lbhotline;
    @FXML
    private TextField hotline;
    @FXML
    private TextField diachi;

    private JdbcDAO repo = new JdbcDAO();
    private KienNghi kienNghi;
    private String maCQ;
    public void handleVisible(boolean check) throws SQLException {
        lbdiachi.setVisible(check);
        lbhotline.setVisible(check);
        hotline.setVisible(check);
        diachi.setVisible(check);
        if(check){
            CoQuanPhanHoi coQuanPhanHoi=repo.getCoQuanPhanHoiByMaCQ(maCQ);
            diachi.setText(coQuanPhanHoi.getDiaChi());
            hotline.setText(coQuanPhanHoi.getHotline());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            handleVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cq1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq1.getText());
                maCQ = "BXDHM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq2.getText());
                maCQ = "CAHM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq3.getText());
                maCQ = "CAPTMM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq4.getText());
                maCQ = "CATL";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq5.getText());
                maCQ = "CATPHN";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq6.getText());
                maCQ = "QLTTNANN";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq7.getText());
                maCQ = "STTTTHN";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq8.getText());
                maCQ = "TATDP";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq9.getText());
                maCQ = "TNMT";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq10.getText());
                maCQ = "TNMTHM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq11.getText());
                maCQ = "TVS1";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq12.getText());
                maCQ = "UBNDHM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cq13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menu.setText(cq13.getText());
                maCQ = "UBNDPHM";
                try {
                    handleVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void Confirm(ActionEvent e) throws SQLException, IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận ");
        alert.setContentText("Bạn đã chắc chắn với thông tin vừa nhập chứ?");

        ButtonType buttonTypeYes = new ButtonType("Xác nhận", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Hủy", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes){
            repo.updateStatus(kienNghi,2);
            repo.themKN_Coquan(kienNghi.getMa_kien_nghi(), maCQ);
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/PheDuyetKN.fxml"));
            Parent p = loader.load();

            AdminHomeController.global_pane.setCenter(p);
        }
        else if(result.get()==buttonTypeNo){
            //do nothing
        }
    }
    public void Cancle(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AdminFXML/PheDuyetKN/ChapNhanPheDuyet.fxml"));
        Parent p = loader.load();

        AdminHomeController.global_pane.setCenter(p);
    }

    public void set_inf(KienNghi kn) {
        this.kienNghi=kn;
    }
}
