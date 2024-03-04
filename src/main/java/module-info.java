module com.example.differentialequationslab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.YK to javafx.fxml;
    exports com.example.YK;
}