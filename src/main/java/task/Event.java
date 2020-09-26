package task;

/**
 * The type Event, which extends Task
 *  Attributes are its description (name)
 *  and 'at',the date of the event
 */
public class Event extends Task {

    protected String at;

    /**
     * Constructor for the Event class
     *
     * @param description name of the event
     * @param at date of the event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Converts the task into string form to be displayed on list
     *
     * @return task in string
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}