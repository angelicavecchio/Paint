package com.example.FileManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class FileServices {

     public void save(Canvas canvas, File file) throws IOException {
        if(file!=null){
        try{
        Image image = canvas.snapshot(null, null);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
     
        ImageIO.write(bImage, "png", file);
        System.out.println("Immagine salvata");

        }catch(Exception e){
            e.printStackTrace();
        }

               }else{
        System.out.println("Salvataggio non andato a buon fine");
    }
    }

    
    public Image load(File file) throws IOException {
         if(file==null || !file.exists()){
            throw new IOException("Errore");
         }
            return new Image(file.toURI().toString()); 
            
        }

}
