package parser;

import exceptions.EmptyDeadline;
import exceptions.EmptyEvent;
import exceptions.EmptyToDo;

public abstract class Parser {

    public static void emptyChecker(String taskName,int taskFlag) throws EmptyToDo, EmptyDeadline, EmptyEvent {
        if (taskName.equals("") && taskFlag == 1){
            throw new EmptyToDo();
        }else if ( taskName.equals("") && taskFlag == 2){
            throw new EmptyDeadline();
        } else if ( taskName.equals("") && taskFlag == 3 ){
            throw new EmptyEvent();
        }
    }
}
