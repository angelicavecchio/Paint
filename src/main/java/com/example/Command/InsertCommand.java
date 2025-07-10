package com.example.Command;

import com.example.Product.ShapeInterface;

import javafx.scene.layout.Pane;

public class InsertCommand implements Command{

    private final ShapeInterface shape;
    private final Pane workspace;

    public InsertCommand(Pane workspace, ShapeInterface shape){
        this.shape = shape;
        this.workspace = workspace;
    }

    @Override
    public void execute() {
        workspace.getChildren().addAll(shape.toJavaFxShape());
    }

    @Override
    public void undo() {
        workspace.getChildren().remove(shape.toJavaFxShape());
    }

}
