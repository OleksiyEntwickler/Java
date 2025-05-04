package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Menu {

    @FXML
    public AnchorPane menueins;
    public AnchorPane menuzwei;
    public AnchorPane menudrei;
    public Button schliessenid;

    @FXML
    void initialize() {
        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
            BackgroundSize.AUTO,
            false,
            false,
            true,
            true);
        Image img1 = new Image("file:../Project_final/Img/2_bild.jpg");
        Background bg1 = new Background(new BackgroundImage(img1,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            size));
        menueins.setBackground(bg1);

        Image img2 = new Image("file:../Project_final/Img/3_bild.jpg");
        Background bg2 = new Background(new BackgroundImage(img2,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            size));
        menuzwei.setBackground(bg2);

        Image img3 = new Image("file:../Project_final/Img/4_bild.jpg");
        Background bg3 = new Background(new BackgroundImage(img3,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            size));
        menudrei.setBackground(bg3);


    }

    @FXML
    public void ersteZuruck(ActionEvent event) throws Exception{
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menuland(ActionEvent event) throws Exception {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("countries.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Länder");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menusuch(ActionEvent event) throws Exception {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("search.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Suchen");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menucontact(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("contact.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Rückmeldung");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void schliessen(ActionEvent event) {
        Stage stage2 = (Stage) schliessenid.getScene().getWindow();
        stage2.close();
    }
}
