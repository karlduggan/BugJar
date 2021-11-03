module BugJar {
	exports application;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires java.sql;
	
	opens application to javafx.fxml;
	
	
}