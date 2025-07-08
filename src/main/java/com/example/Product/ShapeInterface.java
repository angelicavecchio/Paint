package com.example.Product;

import com.example.Visitor.VisitorShape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public interface ShapeInterface {

    //ottenere coordinate x,y
    //settare coordinate
    //ottenere colore bordo
    //settare colore bordo
    //clonare shape
    //stampare shape
    //mandare in avanti una shape
    //mandarla in secondo piano


    double getShapeX();
    double getShapeY();
    void setShapeX(double x);
    void setShapeY(double y);
    Color getStrokeColor();
    void setStrokeColor(Color color);
    ShapeInterface clone();
    String toString();
    void setFront();
    void setBack();
    void accept(VisitorShape v);
    Shape toJavaFxShape();
    



}
