package com.example.Product;

import com.example.Visitor.VisitorShape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class SegmentShape extends Line implements Shape1D{
    //estendiamo la super classe Line (di javafx)
    //questo è il prodotto1D concreto
    //definisco lo spessore della forma a 4px(pixel) e sarà fisso e non modificabile dall'utente
     private final double D1_STROKE_WIDTH = 4;
     //definisco costruttore che verrà chiamato quando si dovrà creare la linea(quindi andrà specificata la posizione e il colore e la lunghezza )
     //questo costruttore chiama il costruttore di Line e gli passa inzialmente tutti 0 per la posizione di partenza e fine della linea

     public SegmentShape(double x, double y, Color color,double l){
        super(0.,0.,0.,0.);
        //setta la posizione del centro, colore,lunghezza con i dati passati al costruttore di LineShape
        setShapeX(x);
        setShapeY(y);
        setStrokeColor(color);
        setStrokeWidth(D1_STROKE_WIDTH);
        setLength(l);

     }

    @Override
    public double getShapeX() {
        //una linea ha un punto iniziale uno finale
        //questo metodo restituisce il centro della linea
       return (getStartX()+getEndX())/2;
    }

    @Override
    public double getShapeY() {
        return (getStartY()+getEndY())/2;
        
    }

    @Override
    public void setShapeX(double x) {
    //quando setto il centro della linea=> mi calcola in automatico il nuovo punto iniziale e finale 
    //infatti nel costruttore poi questi punti verranno passati in automatico quando setto il punto centrale

    double y = getShapeY();
    //prendo la coordinata y del centro perchè sto solo cambiando la x, la y resta la stessa
    //CALCOLO COORDINATE VETTORE DIREZIONE, VETTORE CHE STA SOPRA LA MIA LINEA E CHE MI INDICA LA DIREZIONE DELLA RETTA
     double dx= getEndX()-getStartX(); //x1-x
     double dy = getEndY() - getStartY(); //y1-y 
     double midLength = Math.hypot(dx, dy) /2; //mi da la metà della linea 
     double thete = Math.atan2(dy, dx); //mi torna l'angolo corrente in radianti 
     double sin = Math.sin(thete); //mi servono seno e coseno per calcolare nuovi punti 
     //seno per spostamento verticale
     //coseno per spostamento orizzontale
     double cos = Math.cos(thete);

     setStartX(x-cos*midLength);
     setStartY(y-sin*midLength);
     setEndX(x+cos*midLength);
     setEndY(y+sin*midLength);    
    }

    @Override
    public void setShapeY(double y) {
        double x= getShapeX();
        double dx= getEndX()-getStartX(); //x1-x
        double dy = getEndY() - getEndX(); //y1-y 
        double midLength = Math.hypot(dx, dy) /2; //mi da la metà della linea 
        double thete = Math.atan2(dy, dx); //mi torna l'angolo corrente in radianti 
        double sin = Math.sin(thete); //mi servono seno e coseno per calcolare nuovi punti 
      
         double cos = Math.cos(thete);

     setStartX(x-cos*midLength);
     setStartY(y-sin*midLength);
     setEndX(x+cos*midLength);
     setEndY(y+cos*midLength);  

        
    }

    //uso i metodi già esistenti di Line
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
    public void setLength(double l) {
         double cx = getShapeX();
        double cy = getShapeY();

        double dx = getEndX() - getStartX();    
        double dy = getEndY() - getStartY();
        double theta = Math.atan2(dy, dx);     

        double half = l / 2.0; 

        double cos = Math.cos(theta);   // ricalcolo le coordinate degli estremi
        double sin = Math.sin(theta);
        setStartX(cx - cos * half);
        setStartY(cy - sin * half);
        setEndX(  cx + cos * half);
        setEndY(  cy + sin * half);
    }

    @Override
    public double getLength() {
        double dx = getEndX() - getStartX();
        double dy = getEndY() - getStartY();

        return Math.hypot(dx, dy);
    }

    @Override
    public ShapeInterface clone(){
       
        return new SegmentShape(getShapeX(), getShapeY(), getStrokeColor(), getLength());
    }


    /**
     * Restituisce una rappresentazione testuale del segmento in formato CSV
     *
     * @return la stringa CSV descrittiva del segmento
     */
    public String toString() {
        return "Shape1D;SegmentShape;" + getShapeX() + ";" + getShapeY() + ";" + getStrokeColor() + ";" + getLength();
    }

    @Override
    public void accept(VisitorShape v) {
        v.visit(this);
    }

    

}
