package com.example.Product;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class ElipseShape extends Ellipse implements Shape2D {

    public ElipseShape(double x, double y, Color fill, Color stroke, double width, double height){
        super(0, 0, 0, 0);
        setShapeX(x);
        setShapeY(y);
        setFillColor(fill);
        setStrokeColor(stroke);
        setShapeWidth(width);
        setShapeHeight(height);
    }

    @Override
    public double getShapeX() {
        return getCenterX();
    }

    @Override
    public double getShapeY() {
        return getCenterY();
    }

    @Override
    public void setShapeX(double x) {
       setCenterX(x);
    }

    @Override
    public void setShapeY(double y) {
        setCenterY(y);
    }

    @Override
    public Color getStrokeColor() {
        return (Color) getStroke();
    }

    @Override
    public void setStrokeColor(Color color) {
       setStroke(color);
    }

    @Override
    public void setFront() {
        toFront();
    }

    @Override
    public void setBack() {
        toBack();
    }

    @Override
    public Shape toJavaFxShape() {
       return this;
    }

    @Override
    public double getShapeWidth() {
        return getRadiusX()*2;
    }

    @Override
    public void setShapeWidth(double width) {
        double cx= getShapeX();
        double raggio = width/2;
        setRadiusX(raggio);
        setShapeX(cx);
    }

    @Override
    public double getShapeHeight() {
       return getRadiusY()*2;
    }

    @Override
    public void setShapeHeight(double height) {
       double cY= getShapeY();
        double raggio = height/2;
        setRadiusY(raggio);
        setShapeY(cY);
    }

    @Override
    public Color getFillColor() {
       return (Color) getFill();
    }

    @Override
    public void setFillColor(Color color) {
       setFill(color);
    }


    @Override
    public ShapeInterface clone(){
        return new ElipseShape(getShapeX(), getShapeY(), getFillColor(), getStrokeColor(), getShapeWidth(), getShapeHeight());
    }

    @Override
    public String toString(){
       return "Shape2D;ElipseShape;" + getShapeX() + ";" + getShapeY() + ";" + getStrokeColor() + ";" + getShapeWidth() + ";" + getShapeHeight() + ";" + getFillColor();    
    }


}
