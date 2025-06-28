package com.example.Product;

import javafx.scene.paint.Color;

public interface Shape2D extends ShapeInterface{

    // forme 2d
    //tipi di forme 2d supportate

    enum TYPE_2D{
        RECTANGLE,
        ELLIPSE
    }

    //SETTARE E OTTENERE COLORE RIEMPIMENTO 
    //SETTARE E OTTENERE LARGHEZZA E LUNGHEZZA FORMA

    double getShapeWidth();
    void   setShapeWidth(double width);
    double getShapeHeight();
    void setShapeHeight(double height);
    Color getFillColor();
    void setFillColor(Color color);


}
