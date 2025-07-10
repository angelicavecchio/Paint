package com.example.Command;

import com.example.Product.ShapeInterface;

import javafx.scene.layout.Pane;

public class BringBackCommand implements Command{
    private final ShapeInterface shape;
    private final Pane workspace;
    private int oldIndex;


    public BringBackCommand(Pane workspace, ShapeInterface shape){
        this.shape = shape;
        this.workspace = workspace;
    }


    @Override
    public void execute() {
        oldIndex = workspace.getChildren().indexOf(shape.toJavaFxShape());
        shape.setBack();
       
    }


    @Override
    public void undo() {
        workspace.getChildren().remove(shape.toJavaFxShape());
        workspace.getChildren().add(oldIndex,shape.toJavaFxShape());
    }

}
