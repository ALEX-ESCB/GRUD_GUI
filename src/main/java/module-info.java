module com.pmp.proyecto.grud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.pmp.proyecto.grud to javafx.fxml;
    opens com.pmp.dao to javafx.base;
    exports com.pmp.proyecto.grud;
    
    
}
