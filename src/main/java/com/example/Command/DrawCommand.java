package com.example.Command;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCommand implements Command {

    private GraphicsContext gc;
    private double x;
    private double y;
    private double size;
    private Color color;
    
    public DrawCommand(GraphicsContext gc,double x,double y, double size, Color color){
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    @Override
    public void execute() {
        gc.setFill(color);
        gc.fillRect(x, y, x, size);
       
    }

    @Override
    public void undo() {
        gc.clearRect(x, y, x, size);
    }

}
