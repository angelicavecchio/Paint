package com.example.Visitor;
import com.example.Product.Shape1D;
import com.example.Product.Shape2D;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class VisitorConcrete implements VisitorShape{

    private final String DECIMAL_REGEX = "^[0-9]+(\\\\.[0-9]+)?$";

    @Override
    public void visit(Shape1D shape1d) {
        //per le shape1D va modificata la lunghezza solo
        //quando schiaccio sulla forma si apre un dialog nel quale inserisco la nuova misura e schiaccio ok (ovviamente misure devono essere interi decimali positivi)
    
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Resize");
        dialog.setHeaderText("Enter new length (Must be >0)");
        
        //aggiungere campo input
        TextField input = new TextField(String.valueOf(shape1d.getLength()));

        //aggiungere layout
    
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label label = new Label("Length");
        grid.addRow(0, label,input);
        
        dialog.getDialogPane().setContent(grid);

        //aggiungere bottoni 


        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton,ButtonType.CANCEL);

        Node confirmButton = dialog.getDialogPane().lookupButton(okButton);

        //disabilitare/ abilitare il bottone in base al contenuto del campo 
        input.textProperty().addListener((obs,oldValue,newValue) -> {
            confirmButton.setDisable(newValue.trim().isEmpty());

        });

        //validazione

        confirmButton.addEventFilter(ActionEvent.ACTION, event -> {
            String length = input.getText().trim(); //prendo l'input e rimuovo eventuali spazi 

          if (!length.matches(DECIMAL_REGEX)) {
    Alert error = new Alert(AlertType.ERROR);
    error.setTitle("Invalid input");
    error.setContentText("It must be a decimal positive number");
    error.showAndWait();
    event.consume();
} else {
    double lengthShape = Double.parseDouble(length);
    shape1d.setLength(lengthShape);
}

        dialog.showAndWait();
    });

    
    
    
    
    
    }

    @Override
    public void visit(Shape2D shape2d) {
        //qui posso anche voler cambiare solo uno dei due valori
        //qui altezza e larghezza

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Resize");
        dialog.setHeaderText("Enter new height and width (Must be >0)");

        TextField text1 = new TextField(String.valueOf(shape2d.getShapeWidth()));
        TextField text2 = new TextField(String.valueOf(shape2d.getShapeHeight()));

        //layout 
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        dialog.getDialogPane().setContent(grid);

        Label width = new Label("Width");
        Label heigth = new Label("Height");

        grid.addRow(0,width,text1);
        grid.addRow(1, heigth, text2);

        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton,ButtonType.CANCEL);

        Node confirmButton = dialog.getDialogPane().lookupButton(okButton);//riferimento al bottone ok

        //dobbiamo avere un listener condiviso che disabilita il bottono solo se entrambi sono vuoti

        ChangeListener<String> changeListener = (obs,oldValue,newValue) -> {

            boolean valid = !text1.getText().trim().isEmpty() &&
                            !text2.getText().trim().isEmpty();

            confirmButton.setDisable(!valid);
        };

        text1.textProperty().addListener(changeListener);
        text2.textProperty().addListener(changeListener);

    
        confirmButton.addEventFilter(ActionEvent.ACTION, event->{
           String newWidth = text1.getText().trim();
           String newHeight = text2.getText().trim();

        if (!newWidth.matches(DECIMAL_REGEX) || !newHeight.matches(DECIMAL_REGEX)) {
    Alert error = new Alert(AlertType.ERROR);
    error.setTitle("Invalid input");
    error.setContentText("It must be a decimal positive number");
    error.showAndWait();
    event.consume();
} else {
    double newW = Double.parseDouble(newWidth);
    double newH = Double.parseDouble(newHeight);
    shape2d.setShapeHeight(newH);
    shape2d.setShapeWidth(newW);
}
        });

        dialog.showAndWait();
    }

}
