module com.example.differentialequationslab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;



    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;


    opens com.example.YK to javafx.fxml;
    exports com.example.YK;

}