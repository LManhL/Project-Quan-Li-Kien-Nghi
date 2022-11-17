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

    opens com.example.projectquanlikiennghi to javafx.fxml;
    exports com.example.projectquanlikiennghi;
    exports com.example.projectquanlikiennghi.controller.controllerLogin;
    opens com.example.projectquanlikiennghi.controller.controllerLogin to javafx.fxml;
}