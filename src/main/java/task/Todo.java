package task;

/**
 * The type Todo, which extends Task
 * only have the description (name) attribute
 */
public class Todo extends Task {

    /**
     * Constructor for the To do Class
     *
     * @param description name of the to do
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the to do task into string format
     *
     * @return string form of the task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
