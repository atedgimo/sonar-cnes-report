package fr.cnes.sonar.report.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller for the JavaFX application.
 * @author lequal
 */
public class ExportController {

    ///
    /// Panes
    ///

    @FXML
    private AnchorPane rootPane;

    ///
    /// Buttons
    ///

    @FXML
    private Button outputBrowseButton;

    @FXML
    private Button wordBrowseButton;

    @FXML
    private Button excelBrowseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button generateButton;

    ///
    /// Fields
    ///

    @FXML
    private TextField hostField;

    @FXML
    private TextField outputField;

    @FXML
    private TextField projectIdField;

    @FXML
    private TextField authorField;

    @FXML
    private DatePicker dateBox;

    @FXML
    private ComboBox languageBox;

    @FXML
    private TextField wordBrowseField;

    @FXML
    private TextField excelBrowseField;

    ///
    /// Checkbox
    ///

    @FXML
    private CheckBox reportCheckbox;

    @FXML
    private CheckBox issuesCheckbox;

    @FXML
    private CheckBox confCheckbox;

    ///
    /// File browsers
    ///

    @FXML
    private void browseOutputFolder(final ActionEvent event) throws IOException {
        final DirectoryChooser fileChooser = new DirectoryChooser();
        File file = fileChooser.showDialog(rootPane.getScene().getWindow());
        if(null!=file) {
            outputField.setText(file.getCanonicalPath());
        }
    }

    @FXML
    private void browseWordTemplate(final ActionEvent event) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
        if(null!=file) {
            wordBrowseField.setText(file.getCanonicalPath());
        }
    }

    @FXML
    private void browseExcelTemplate(final ActionEvent event) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
        if(null!=file) {
            excelBrowseField.setText(file.getCanonicalPath());
        }
    }

    @FXML
    private void resetForm(final ActionEvent event) throws IOException {
        hostField.setText("");
        projectIdField.setText("");
        outputField.setText("");
        authorField.setText("");
        dateBox.setValue(LocalDate.now());
        languageBox.setValue("");
        wordBrowseField.setText("");
        excelBrowseField.setText("");
    }

    @FXML
    private void generateReport(final ActionEvent event) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
        if(null!=file) {
            excelBrowseField.setText(file.getCanonicalPath());
        }
    }

}
