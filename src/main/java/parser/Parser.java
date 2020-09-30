package parser;

import exceptions.EmptyDeadline;
import exceptions.EmptyEvent;
import exceptions.EmptyToDo;

/**
 * Parser deals with making sense of the user's input command
 */
public abstract class Parser {
    /**
     * Checks if the task to be input is empty
     *
     * @param taskName task input by user
     * @param taskFlag to differentiate which error message to display
     */
    public static void emptyChecker(String taskName, int taskFlag) throws EmptyToDo, EmptyDeadline, EmptyEvent {
        if (taskName.equals("") && taskFlag == 1){
            throw new EmptyToDo();
        }else if ( taskName.equals("") && taskFlag == 2){
            throw new EmptyDeadline();
        } else if ( taskName.equals("") && taskFlag == 3 ){
            throw new EmptyEvent();
        }
    }
}
