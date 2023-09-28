module org.javacoders.LibraryProject {
	
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires org.hibernate.orm.core;
	requires java.xml;
	requires jakarta.persistence;

    opens org.javacoders.LibraryProject;
    opens org.javacoders.entity;
    exports org.javacoders.LibraryProject;
}
