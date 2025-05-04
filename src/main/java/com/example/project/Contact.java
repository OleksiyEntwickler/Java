package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Contact {

    @FXML
    public TextField fragefield;
    public TextArea contactfield;
    public AnchorPane mapview;
    public Button close;
    public TextField emailfield;
    public TextField meld;

    private Fragen frage = new Fragen();

    @FXML
    public void onSend(ActionEvent event) throws Exception {
        var valid = true;
        if (fragefield.getText().isEmpty()) {
            valid = false;
            meld.setVisible(true);
            meld.setText("Geben Sie eine Frage ein");
        } else if (emailfield.getText().isEmpty()) {
            valid = false;
            meld.setVisible(true);
            meld.setText("Geben Sie eine E-Mail Adresse ein");
        } else if (emailfield.getText().contains("@")) {
            meld.setVisible(true);
            meld.setText("Ihre Frage werde gesendet");
            frage.save(fragefield.getText(), emailfield.getText());
            fragefield.clear();
        }
        else {
            meld.setVisible(true);
            meld.setText("Geben Sie eine richtige E-mail Adresse ein");
    }
    }

    @FXML
    void initialize() {
        contactfield.setText("Graf-Adolf-Straße 12, 40212 Düsseldorf" + "\n" + "*Telefonnummer");
        contactfield.setEditable(false);

        try {
            WebView webView = new WebView();
            webView.getEngine().load("https://maps.google.com");
            webView.setPrefWidth(1200);
            mapview.getChildren().add(webView);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClose(ActionEvent event5) {
        Stage stage2 = (Stage) close.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void onBack(ActionEvent event4) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}