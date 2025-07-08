package com.example.FileManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.example.Factory.Shape1DCreator;
import com.example.Factory.Shape2DCreator;
import com.example.Product.ElipseShape;
import com.example.Product.RectangleShape;
import com.example.Product.SegmentShape;
import com.example.Product.Shape1D;
import com.example.Product.Shape2D;
import com.example.Product.ShapeInterface;
import javafx.scene.paint.Color;

public class FileServices {

    public static boolean saveFile(List<ShapeInterface> shapes,String file){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))){

            for(ShapeInterface shape: shapes){
                writer.println(shape.toString());
            }

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public static List<ShapeInterface> loadFile(String file){

    List<ShapeInterface> shapes = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
        String linea;

        while((linea=reader.readLine()) != null){
            String[] campi = linea.split(";");

            //Parsing 1D shapes
            if(campi[0].equals("Shape1D")){
                //SegmentShape
                if(campi[1].equals("SegmentShape")){
                    double centerX = Double.parseDouble(campi[2]);
                    double centerY = Double.parseDouble(campi[3]);
                    Color stroke = Color.web(campi[4]);
                    double length = Double.parseDouble(campi[5]);

                    Shape1DCreator creator = new Shape1DCreator(Shape1D.TYPE_1D.LINE, stroke);
                    SegmentShape segment = (SegmentShape) creator.createShape();
               
                    segment.setShapeX(centerX);
                    segment.setShapeY(centerY);
                    segment.setLength(length);
                    
                    shapes.add(segment);
               
                }
            }
            // Parsing 2D shapes
                if(campi[0].equals("Shape2D")){
                    //RectangleShape
                    if(campi[1].equals("RectangleShape")) {
                        double centerX = Double.parseDouble(campi[2]);
                        double centerY = Double.parseDouble(campi[3]);
                        Color stroke = Color.web(campi[4]);
                        double width = Double.parseDouble(campi[5]);
                        double height = Double.parseDouble(campi[6]);
                        Color fill = Color.web(campi[7]);

                        Shape2DCreator creator = new Shape2DCreator(Shape2D.TYPE_2D.RECTANGLE, stroke, fill);
                        RectangleShape shape = (RectangleShape) creator.createShape();

                        shape.setShapeX(centerX);
                        shape.setShapeY(centerY);
                        shape.setShapeWidth(width);
                        shape.setShapeHeight(height);

                        shapes.add(shape);
                    }

                    //EllipseShape
                    if(campi[1].equals("EllipseShape")) {
                        double centerX = Double.parseDouble(campi[2]);
                        double centerY = Double.parseDouble(campi[3]);
                        Color stroke = Color.web(campi[4]);
                        double width = Double.parseDouble(campi[5]);
                        double height = Double.parseDouble(campi[6]);
                        Color fill = Color.web(campi[7]);

                        Shape2DCreator creator = new Shape2DCreator(Shape2D.TYPE_2D.ELLIPSE, stroke, fill);
                        ElipseShape shape = (ElipseShape) creator.createShape();

                        shape.setShapeX(centerX);
                        shape.setShapeY(centerY);
                        shape.setShapeWidth(width);
                        shape.setShapeHeight(height);

                        shapes.add(shape);
                    }
                }
            

        }
    }catch(IOException e){
        e.printStackTrace();
    }



    return shapes;


    }
}















