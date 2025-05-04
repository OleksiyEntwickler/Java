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

public class Countries {

    @FXML
    public Button countDeutschImg;
    public Button countUkrImg;
    public Button countFranImg;
    public Button countBritImg;
    public Button menuClose;

    @FXML
    void initialize() {
        Image iv = new  Image("file:../Project_final/Img/Land/1_bild.jpg");
        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                true);
        Background bg = new Background(new BackgroundImage(iv,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));
        countDeutschImg.setBackground(bg);

        Image iv2 = new  Image("file:../Project_final/Img/Land/2_bild.jpg");
        Background bg2 = new Background(new BackgroundImage(iv2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));
        countUkrImg.setBackground(bg2);

        Image iv3 = new  Image("file:../Project_final/Img/Land/3_bild.jpg");
        Background bg3 = new Background(new BackgroundImage(iv3,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));
        countFranImg.setBackground(bg3);

        Image iv4 = new  Image("file:../Project_final/Img/Land/4_bild.jpg");
        Background bg4 = new Background(new BackgroundImage(iv4,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size));
        countBritImg.setBackground(bg4);

    }

    @FXML
    public void countDeutsch(ActionEvent event) throws Exception{
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("land/deutschland.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Deutschland");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void countUkr(ActionEvent event) throws Exception{
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("land/ukraine.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Ukraine");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void countFran(ActionEvent event) throws Exception{
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("land/frankreich.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Frankreich");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void countBrit(ActionEvent event) throws Exception{
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("land/britannien.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Großbritannien");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menuZuruck(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menuClose(ActionEvent event) {
        Stage stage2 = (Stage) menuClose.getScene().getWindow();
        stage2.close();
    }
}
