module com.example.projectquanlikiennghi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires java.sql;

    opens com.example.projectquanlikiennghi to javafx.fxml;
    exports com.example.projectquanlikiennghi;
    exports com.example.projectquanlikiennghi.controller.controllerLogin;
    opens com.example.projectquanlikiennghi.controller.controllerLogin to javafx.fxml;

    exports com.example.projectquanlikiennghi.controller.controllerAdmin;
    opens com.example.projectquanlikiennghi.controller.controllerAdmin to javafx.fxml;

    exports com.example.projectquanlikiennghi.controller.controllerUser;
    opens com.example.projectquanlikiennghi.controller.controllerUser to javafx.fxml;

    opens com.example.projectquanlikiennghi.models to javafx.base;
    exports com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN;
    opens com.example.projectquanlikiennghi.controller.controllerAdmin.PheDuyetKN to javafx.fxml;
    exports com.example.projectquanlikiennghi.controller.controllerAdmin.PhanHoiKN;
    opens com.example.projectquanlikiennghi.controller.controllerAdmin.PhanHoiKN to javafx.fxml;
    exports com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser;
    opens com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyUser to javafx.fxml;
    exports com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKN;
    opens com.example.projectquanlikiennghi.controller.controllerAdmin.QuanLyKN to javafx.fxml;
}