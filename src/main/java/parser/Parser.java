package parser;

import exceptions.EmptyDeadline;
import exceptions.EmptyEvent;
import exceptions.EmptyToDo;
import exceptions.UnknownCommand;

/**
 * Parser deals with making sense of the user's input command
 */
public abstract class Parser {

    /**
     * Checks if task is empty
     *
     * @param inputCommand user input command
     */
    public static void emptyTaskChecker(String inputCommand) throws EmptyToDo, EmptyDeadline, EmptyEvent {
        switch (inputCommand) {
        case "todo":
            throw new EmptyToDo();
        case "deadline":
            throw new EmptyDeadline();
        case "event":
            throw new EmptyEvent();
        }
    }

    /**
     * Checks if deadline or event commands have the correct format
     *
     * @param inputCommand user input command
     */
    public static void missingFormatChecker(String inputCommand) throws UnknownCommand {
        if ( !(inputCommand.contains("/at") || inputCommand.contains("/by")) ){
            throw new UnknownCommand();
        }
    }
}
