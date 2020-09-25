package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    private LocalDate at;
    final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, LocalDate at) {
        super(description);
        this.at = at;
    }

    @Override // calls Task's toString
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.format(formatter) + ")";
    }
}