package com.example.Visitor;

import com.example.Product.Shape1D;
import com.example.Product.Shape2D;

public interface VisitorShape {

    void visit(Shape1D shape1D);
    void visit(Shape2D shape2d);
    
}
