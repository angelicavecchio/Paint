package com.example.Command;

import java.util.Stack;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;


public class CommandHistory {

    private final Stack<Command> history; 
    private final ReadOnlyBooleanWrapper empty ;


    public CommandHistory(){
        this.history = new Stack<>();
        this.empty = new ReadOnlyBooleanWrapper(true);

    }
    //fare i soliti comandi per stack (push, pop) se è vuoto

    public void push(Command command){
        history.push(command);
        updateState();
    }

    public Command pop(){
        Command commandLast = history.pop();       
         updateState();
        return commandLast;
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }

    //ora get e set per la proprietà osservabile

    public ReadOnlyBooleanProperty getEmptyProperty(){
        return empty.getReadOnlyProperty();
    }

    public void updateState(){
        empty.set(history.isEmpty()); //se lo stack è vuoto alla proprietà osservabile gli viene assegnato true

    }

}
