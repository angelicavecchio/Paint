package com.example.Product;

public interface Shape1D extends ShapeInterface{

    //definisco i tipi di forme 1d
    //una forma 1D
    //ha una lunghezza

    enum TYPE_1D{
        LINE
    }

    void setLength(double l);
    double getLength();

}
