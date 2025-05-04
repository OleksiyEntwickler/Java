package com.example.project.land;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Frankreich implements Initializable {

    @FXML
    public BorderPane borderImg;
    public Button ondreiclose;
    public SplitMenuButton menu;
    public TextArea textdl;
    public ImageView imgdl;
    public Hyperlink hl1t;
    public SplitPane spane;
    public ImageView imgdl1;
    public ImageView imgdl11;

    @FXML
    public void initialize(URL url, ResourceBundle rb){

        menu.setText("Sehenswürdigkeiten");
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:Buch3");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Frankreich");
            while (rs.next()) {
                String name1 = rs.getString("Titel");
                String bes1 = rs.getString("Beschreibung");
                String bild = rs.getString("Bild");
                String bild2 = rs.getString("Bild2");
                String bild3 = rs.getString("Bild3");
                String link = rs.getString("Link");
                Image img1 = new Image(String.valueOf(new URL(bild)));
                Image img12 = new Image(String.valueOf(new URL(bild2)));
                Image img123 = new Image(String.valueOf(new URL(bild3)));
                MenuItem item1 = new MenuItem(name1);
                menu.getItems().add(item1);
                item1.setOnAction(e -> {
                    spane.setVisible(true);
                    menu.setText(name1);
                    hl1t.setVisible(true);
                    textdl.setText(name1 + "\n" + bes1);
                    textdl.setWrapText(true);
                    imgdl.setImage(img1);
                    imgdl1.setImage(img12);
                    imgdl11.setImage(img123);
                    hl1t.setText(link);
                });}
        } catch(Exception e){
            e.printStackTrace();
        }


        Image iv1 = new  Image("file:../Project_final/Img/Land/3_bild.jpg");
        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                true);
        Background bg = new Background(new BackgroundImage(iv1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));
        borderImg.setBackground(bg);

    }

    @FXML
    public void ondrei(ActionEvent event) {
        Stage stage2 = (Stage) ondreiclose.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void onZwei(ActionEvent event1) {
        try {
            URL url = new File("C:/Users/oleks/Desktop/Project_final/src/main/resources/com/example/project/countries.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
            stage.setTitle("Länder");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void hl1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(hl1t.getText()));
    }
}
