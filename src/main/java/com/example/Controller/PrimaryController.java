package com.example.Controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javax.imageio.ImageIO;
import com.example.Command.*;
import com.example.FileManager.FileServices;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;

import java.awt.image.BufferedImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

    private Stage stage;
    private Stack<Command> stackCommand = new Stack<>();
    private FileServices fileServices;

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    
    @FXML
    private TextField brushSize;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button undoButton;
     @FXML
    private VBox vbox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Sto inizializzando la mia applicazione ");
        
    
    Platform.runLater(() -> {
    canvas.widthProperty().bind(canvas.getScene().widthProperty());
    canvas.heightProperty().bind(canvas.getScene().heightProperty().subtract(80));
    System.out.println("Sto sistemando il canvas"); 
                             });

                    fileServices = new FileServices();
            gc = canvas.getGraphicsContext2D();

        
            canvas.setOnMouseDragged(e -> {
            Double size = Double.parseDouble(brushSize.getText());
            double x = e.getX()-size/2;
            double y = e.getY()-size/2;
            Color color = colorPicker.getValue();

            DrawCommand command = new DrawCommand(gc, x, y, size, color);
            command.execute();
            stackCommand.add(command);      
            
         });
         
         
    }


    public void save(){      
     FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save image");

    FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
    fileChooser.getExtensionFilters().add(ef);

    File file = fileChooser.showSaveDialog(stage);
    System.out.println("Sto aprendo il dialog");
     if(file!=null){
        try{
        fileServices.save(canvas, file);

        }catch(Exception e){
            e.printStackTrace();
        }

    }else{
        System.out.println("Salvataggio non andato a buon fine");
    }
    }


 

    public void undo() {
        if(!stackCommand.isEmpty()){
           Command c = stackCommand.pop();
           c.undo();
        
        }

    }


    public void exit(){
        Platform.exit();

    }


    public void open(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        FileChooser.ExtensionFilter eF = new FileChooser.ExtensionFilter("Immagini", "*.png", "*.jpg", "*.jpeg", "*.gif");
        fileChooser.getExtensionFilters().add(eF);

        File file = fileChooser.showOpenDialog(stage);
       try{
        Image image = fileServices.load(file);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight());
           
       }catch(IOException e){
        e.printStackTrace();
       }

        System.out.println("Sto aprendo il dialog");

       

    }


    public void newCanvas(){
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
    }


    
}

