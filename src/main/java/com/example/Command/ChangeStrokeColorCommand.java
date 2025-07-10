package com.example.Command;

import com.example.Product.ShapeInterface;

import javafx.scene.paint.Color;

public class ChangeStrokeColorCommand implements Command{
     private final ShapeInterface shape;
     private  Color prevColor;
     private final Color color;


    public ChangeStrokeColorCommand(ShapeInterface shape, Color color){
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void execute() {
        prevColor = shape.getStrokeColor();
        shape.setStrokeColor(color);
       
    }

    @Override
    public void undo() {
        shape.setStrokeColor(prevColor);
    }

}
