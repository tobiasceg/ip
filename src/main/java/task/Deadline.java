package task;

/**
 * The type Deadline, which extends Task
 * Attributes are its description (name)
 * and 'by', the date and time of the deadline
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructor for the deadline Class
     *
     * @param description name of the deadline
     * @param by date and time of the deadline
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    /**
     * Converts the deadline into string format
     *
     * @return string form of the deadline
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}