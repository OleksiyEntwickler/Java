1.
void initialize() {
Image img = new Image("file:/C:/Users/oleks/Desktop/Project_final/1_bild.jpg");
BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
        BackgroundSize.AUTO,
        false,
        false,
        true,
        false);

Background bg = new Background(new BackgroundImage(img,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        size));

        zweiBorder.setBackground(bg);
    }



2.
public void startHyper(ActionEvent event) throws Exception {
    try {
        Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}



3.
public void startHyper3(ActionEvent event) throws URISyntaxException, IOException {
    System.out.println("Gehen ins Browser");
    Desktop.getDesktop().browse(new URI("www.google.com"));
}

4.
public void startHyper(ActionEvent event) throws Exception{
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) (fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }
}


5.
public void closefirst(ActionEvent event) {
    Stage stage = (Stage) closefirstid.getScene().getWindow();
    stage.close();
}


6.
public void onZwei(ActionEvent event1) {
    try {
        URL url = new File("C:/Users/oleks/Desktop/Project_final/src/main/resources/com/example/project/countries.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        stage.setTitle("Countries");
        stage.setScene(scene);
        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }
}


7.
<!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.49.1.0</version>
</dependency>


Datenbank connow = new Datenbank();
Connection conDB = connow.getDBC();
        menu.setText("Titel");
String conque = "SELECT Titel FROM Buch";
        try {
Statement stat = conDB.createStatement();
ResultSet queport = stat.executeQuery(conque);
            while (queport.next()){
String name1 = queport.getString("Titel");
//menu1 = new MenuItem(name1);
                menu.getItems().add(new MenuItem(name1));
        }
        } catch (Exception e){
        e.printStackTrace();
        }

8.
<!-- Shade-Plugin zum Erzeugen eines ausführbaren Jars -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.4.1</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer
                                        implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.example._a08_contacts_01_d.Main</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


8.1
start javaw -jar app.jar
rem pause



9.






