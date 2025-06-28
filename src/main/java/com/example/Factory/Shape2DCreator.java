package com.example.Factory;

import com.example.Product.ElipseShape;
import com.example.Product.RectangleShape;
import com.example.Product.Shape2D;
import com.example.Product.ShapeInterface;

import javafx.scene.paint.Color;

public class Shape2DCreator implements ShapeCreator{
    public Shape2D.TYPE_2D type;
    public Color stroke;
    public Color fill;
    public double S2_WIDTH=60;
    public double S2_HEIGTH = 30;

    public Shape2DCreator(Shape2D.TYPE_2D type, Color stroke, Color fill){
        this.type = type;
        this.stroke = stroke;
        this.fill = fill;
    
    }


    @Override
    public ShapeInterface createShape() {
        if(this.type.equals(Shape2D.TYPE_2D.RECTANGLE)){
            return new RectangleShape(0, 0, stroke, fill, S2_WIDTH, S2_HEIGTH);
        }else if(this.type.equals(Shape2D.TYPE_2D.ELLIPSE)){
            return new ElipseShape(0, 0, fill, stroke, S2_WIDTH, S2_HEIGTH);
        }else{
            return null;
        }
       
    }

    @Override
    public void setStrokeColor(Color color) {
        this.stroke = color;
    }

    public void setFillColor(Color color) {
        this.fill = color;
    }

}
