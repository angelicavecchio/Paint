package com.example.Command;

import com.example.Product.Shape2D;

import javafx.scene.paint.Color;

public class ChangeFillColorCommand implements Command{

     private final Shape2D shape;
     private  Color prevColor;
     private final Color color;


    public ChangeFillColorCommand(Shape2D shape, Color color){
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void execute() {
        prevColor = shape.getFillColor();
        shape.setFillColor(color);
       
    }

    @Override
    public void undo() {
        shape.setFillColor(prevColor);
    }
}
