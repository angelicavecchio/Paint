package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * JavaFX drawing application that loads a view from an FXML file,
 * sets the window title,size and icon, and configures its resize behavior.
 */

 
public class App extends Application {

    private static Scene scene;
    private final String fileFxml = "/com/example/View/paint.fxml";
    private final int WIDTHSCENE = 800;
    private final int HEIGHTSCENE = 600;


    /**
     Loads the layout defined in 'paint.fxml', creates a Scene with fixed dimensions,
     and configures the primary Stage with a title and disables window resizing.
     * @param stage the primary stage on which the scene is set
     *  @throws IOException if the FXML file is missing or invalid
     */

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fileFxml));
        AnchorPane root = loader.load();
        scene = new Scene(root,WIDTHSCENE,HEIGHTSCENE);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.getIcons().add(new Image(getClass().getResource("/com/example/icon.png").toExternalForm()));
        stage.setResizable(false);
        stage.show();
    }

   
    /**  Main program  
     * @param args (not used)
     */
    public static void main(String[] args) {
        launch();
    }

}