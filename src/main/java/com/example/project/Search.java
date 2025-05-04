package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    public BorderPane borderImg;
    public SplitPane spane;
    public VBox textdl;
    public AnchorPane imgdl1;
    public Hyperlink hl1t;
    public TableView<SearchModul> tableview;
    public TextField searchfield;
    public ImageView imgdl;
    public TableColumn<SearchModul, String> titelcol;
    public TableColumn<SearchModul, String> bildcol;
    public TableColumn<SearchModul, String> typencol;
    public TableColumn<SearchModul, String> bescol;
    public TableColumn<SearchModul, String> landcol;
    public TableColumn<SearchModul, String> linkcol;
    public Button closebut;
    public ImageView imgdl2;
    public ImageView imgdl3;
    public TableColumn bildcol2;
    public TableColumn bildcol3;

    ObservableList<SearchModul> data = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL url, ResourceBundle rb){

        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:Buch3");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Buch");
            while (rs.next()) {
                String name1 = rs.getString("Titel");
                String bes1 = rs.getString("Beschreibung");
                String bild = rs.getString("Bild");
                String bild2 = rs.getString("Bild2");
                String bild3 = rs.getString("Bild3");
                String link = rs.getString("Link");
                String typen = rs.getString("Typen");
                String land = rs.getString("Länder");
                titelcol.setCellValueFactory(new PropertyValueFactory<>("titel"));
                bildcol.setCellValueFactory(new PropertyValueFactory<>("bild"));
                bildcol2.setCellValueFactory(new PropertyValueFactory<>("bild2"));
                bildcol3.setCellValueFactory(new PropertyValueFactory<>("bild3"));
                typencol.setCellValueFactory(new PropertyValueFactory<>("typen"));
                landcol.setCellValueFactory(new PropertyValueFactory<>("land"));
                linkcol.setCellValueFactory(new PropertyValueFactory<>("link"));
                bescol.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
                data.add(new SearchModul(name1, land, typen, bes1, bild, bild2, bild3, link));
                tableview.setItems(data);
                tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                tableview.setRowFactory(tv -> {
                    TableRow<SearchModul> row = new TableRow(){};
                    row.setOnMouseClicked(event1 -> {
                        if (!row.isEmpty() && event1.getClickCount() == 1) {
                            SearchModul rowData = row.getItem();
                            System.out.println("Geklickte Zeile: " + rowData);
                            hl1t.setVisible(true);
                            TextField tf1 = new TextField(rowData.getTitel() + "\n");
                            Image img = new Image(rowData.getBild());
                            Image img2 = new Image(rowData.getBild2());
                            Image img3 = new Image(rowData.getBild3());
                            TextField tf3 = new TextField("Typ: " + rowData.getTypen() + "\n");
                            TextField tf2 = new TextField("Land: " + rowData.getLand() + "\n");
                            TextArea tf4 = new TextArea(rowData.getBeschreibung());
                            TextField tf5 = new TextField(rowData.getLink());
                            tf1.setEditable(false);
                            tf2.setEditable(false);
                            tf3.setEditable(false);
                            tf4.setEditable(false);
                            tf4.setWrapText(true);
                            tf5.setEditable(false);


                            textdl.getChildren().setAll(tf1, tf2, tf3, tf4);
                            imgdl.setImage(img);
                            imgdl2.setImage(img2);
                            imgdl3.setImage(img3);
                            hl1t.setText(rowData.getLink());
                            hl1t.setOnMouseClicked(event2 -> {
                                try {
                                    Desktop.getDesktop().browse(new URI(rowData.getLink()));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                } catch (URISyntaxException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        }
                    });
                    return row;
                });

                FilteredList<SearchModul> filter = new FilteredList<SearchModul>(data, b -> true);
                searchfield.textProperty().addListener((observable, oldValue, newValue) -> {
                    filter.setPredicate(SearchModul -> {
                        if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                            return true;
                        }
                        String searchkeyword = newValue.toLowerCase();
                        if (SearchModul.getTitel().toLowerCase().indexOf(searchkeyword) > -1) {
                            return true;
                        } else if (SearchModul.getLand().toLowerCase().indexOf(searchkeyword) > -1) {
                            return true;
                        } else if (SearchModul.getTypen().toLowerCase().indexOf(searchkeyword) > -1) {
                            return true;
                        } else
                            return false;
                    });
                });

                SortedList<SearchModul> sortedList = new SortedList<>(filter);
                sortedList.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedList);

            }} catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void close(ActionEvent event5) {
        Stage stage2 = (Stage) closebut.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void back(ActionEvent event4) {
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
