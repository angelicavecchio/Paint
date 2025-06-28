package com.example.Product;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleShape extends Rectangle implements Shape2D{
        

    public RectangleShape(double x, double y, Color stroke, Color fill, double width, double height){
        super(0,0,0,0);
        setShapeX(x);
        setShapeY(y);
        setStrokeColor(stroke);
        setFillColor(fill);
        setShapeHeight(height);
        setShapeWidth(width);
    }
    @Override
    public double getShapeX() {
        return getX() + getShapeWidth()/2.0;
    }
    @Override
    public double getShapeY() {
        return getY() + getShapeHeight()/2.0;
    }
    @Override
   public void setShapeX(double centroX) {
    setX(centroX - getWidth()/2);
}
    @Override
    public void setShapeY(double centroY) {
    setY(centroY - getHeight()/2);
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
        return getWidth();
    }
    @Override
    public void setShapeWidth(double width) {
        
    }
    @Override
    public double getShapeHeight() {
        return getHeight();
    }
    @Override
    public void setShapeHeight(double height) {
       
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
        return new RectangleShape(getShapeX(), getShapeY(), getStrokeColor(), getFillColor(), getShapeWidth(), getShapeWidth());
    }

    @Override
    public String toString(){
        return "Shape2D;RectangleShape;" + getShapeX() + ";" + getShapeY() + ";" + getStrokeColor() + ";" + getFillColor() + ";"+ getShapeWidth() + ";" +getShapeHeight();
    }


}
