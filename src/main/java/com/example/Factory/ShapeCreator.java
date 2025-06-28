package com.example.Factory;

import com.example.Product.ShapeInterface;

import javafx.scene.paint.Color;

public interface ShapeCreator {

    ShapeInterface createShape();
    void setStrokeColor(Color color);

}
