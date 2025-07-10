package com.example.Command;

import com.example.Product.ShapeInterface;

import javafx.scene.layout.Pane;

public class DeleteCommand implements Command{
    private final ShapeInterface shape;
    private final Pane workspace;
    private int prevIndex;

    public DeleteCommand(Pane workspace, ShapeInterface shape){
        this.shape = shape;
        this.workspace = workspace;
    }

    /**
     * Esegue il comando rimuovendo la forma dallo spazio di lavoro.
     */
    @Override
    public void execute() {
       prevIndex = workspace.getChildren().indexOf(shape.toJavaFxShape());
       workspace.getChildren().remove(shape.toJavaFxShape());
        
    }

    
    /**
     * Annulla il comando ripristinando la forma nello spazio di lavoro.
     */
    @Override
    public void undo() {
        workspace.getChildren().add(prevIndex, shape.toJavaFxShape());
        
    }




}
