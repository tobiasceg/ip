package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Event, which extends Task
 *  Attributes are its description (name)
 *  and 'at',the date and time of the event
 */
public class Event extends Task {

    private LocalDateTime at;
    final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    /**
     * Constructor for the Event class
     *
     * @param description name of the event
     * @param at date and time of the event
     */
    public Event(String description, LocalDateTime at) {
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
        return "[E]" + super.toString() + " (at: " + at.format(formatter) + ")";
    }
}