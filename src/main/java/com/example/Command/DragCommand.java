package com.example.Command;


import com.example.Product.ShapeInterface;


public class DragCommand implements Command{
    private final ShapeInterface shape;
    private final double x;
    private final double y;  //posizione della shape (x,y)

    public DragCommand(ShapeInterface shape, double x, double y){
        this.shape = shape;
        this.x = x;
        this.y = y;
       
    }


    @Override
    public void execute() {
    // VUOTO perché:
    // 1. Il drag è già stato fatto dall'utente
    // 2. La forma è già nella posizione finale
    // 3. Non c'è niente da "eseguire"
        
    }

    @Override
    public void undo() {
       shape.setShapeX(x);
       shape.setShapeY(y);
       //la riporto alla posizione iniziale
    }


}
