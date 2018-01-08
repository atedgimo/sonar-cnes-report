package fr.cnes.sonar.report.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main entry point for graphical version.
 * @author lequal
 */
public class ReporterGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Pane exporterPane = FXMLLoader.load(getClass().getClassLoader().getResource("export.fxml"));
        final Scene scene = new Scene(exporterPane);
        stage.setScene(scene);
        stage.setTitle("CNES Reporter for SonarQube");
        stage.setResizable(false);
        stage.show();
    }
}
