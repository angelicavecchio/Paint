package com.example.Command;

import com.example.Product.Shape1D;
import com.example.Product.Shape2D;
import com.example.Product.ShapeInterface;
import com.example.Visitor.VisitorConcrete;

public class ResizeCommand implements Command{
     private final ShapeInterface shape;
    private double dim1; //dimensione 1 (le forme 1D hanno solo una dimensione ossia la lunghezza)
    private double dim2; //dimensione 2 (vale solo se è una forma 2D)

    /**
     * Crea un nuovo comando di ridimensionamento per la forma specificata.
     *
     * @param shape la forma da ridimensionare
     */
    public ResizeCommand(ShapeInterface shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        if(shape instanceof Shape1D){
            dim1 = ((Shape1D) shape).getLength();
        }else if(shape instanceof Shape2D){
            dim1 = ((Shape2D) shape).getShapeWidth();
            dim2 = ((Shape2D) shape).getShapeHeight();
        }

    // Applica il resize tramite visitor
        shape.accept(new VisitorConcrete()); //chiamiamo il visitor
        
    }

    @Override
    public void undo() {
       if (shape instanceof Shape1D)
            ((Shape1D) shape).setLength(dim1);
        else{
            ((Shape2D) shape).setShapeWidth(dim1);
            ((Shape2D) shape).setShapeHeight(dim2);
        }
    }

}
