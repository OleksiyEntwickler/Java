package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login {

    @FXML
    public TextField bnField;
    public TextArea talogin;
    public Button logConBut;
    public Button closefirstid;
    public TextField passField1;

    @FXML
    private AnchorPane newImageView;

    @FXML
    void initialize() {
        Image iv = new  Image("file:../Project_final/Img/1_bild.jpg");
        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                false);

        Background bg = new Background(new BackgroundImage(iv,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));

        newImageView.setBackground(bg);

    }

    @FXML
    public void loginValid(ActionEvent event) throws Exception {
        var valid = true;
        if (bnField.getText().isEmpty()) {
            valid = false;
            talogin.setVisible(true);
            talogin.setText("Geben Sie einen Namen ein");
        }
        else if (passField1.getText().isEmpty()) {
            valid = false;
            talogin.setVisible(true);
            talogin.setText("Geben Sie einen Password ein");
        } else if (FileHandler.valid(bnField.getText(), passField1.getText())) {
            logConBut.setVisible(true);
            talogin.setVisible(true);
            talogin.setText("Hallo " + bnField.getText());
            if (bnField.getText().equals("Oleksii")){
                logConBut.setVisible(true);
                talogin.setVisible(true);
                talogin.setText("Hallo Herr " + bnField.getText());
            }}
        else {
            valid = false;
            talogin.setVisible(true);
            logConBut.setVisible(false);
            talogin.setText("Geben Sie einen correct Namen oder Password ein");
        }
    }

    @FXML
    public void loginConnect(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Menu für "+ bnField.getText());
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closefirst(ActionEvent event) {
        Stage stage2 = (Stage) closefirstid.getScene().getWindow();
        stage2.close();
    }
}
