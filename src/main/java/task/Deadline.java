package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
;

public class Deadline extends Task {

    private LocalDateTime by;
    final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override //calls Task's toString
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(formatter) + ")";
    }
}