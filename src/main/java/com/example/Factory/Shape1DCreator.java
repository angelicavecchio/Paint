package com.example.Factory;

import com.example.Product.SegmentShape;
import com.example.Product.Shape1D;
import com.example.Product.ShapeInterface;

import javafx.scene.paint.Color;

public class Shape1DCreator implements ShapeCreator{
    public Shape1D.TYPE_1D type;
    public double D1_LENGTH= 80;
    public Color stroke;

    public Shape1DCreator( Shape1D.TYPE_1D type, Color color, double D1_LENGTH){
        this.D1_LENGTH = D1_LENGTH;
        this.stroke = color;
        this.type = type;

    }

    @Override
    public ShapeInterface createShape() {
        if(this.type.equals(Shape1D.TYPE_1D.LINE)){
            return new SegmentShape(0, 0, stroke, D1_LENGTH);
        }else{
            return null;
        }
        
    }

    @Override
    public void setStrokeColor(Color color) {
        this.stroke = color;
    }

}
