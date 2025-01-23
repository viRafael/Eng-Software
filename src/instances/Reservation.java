package instances;
import java.time.LocalDate;

public class Reservation {
    private User user;
    private Book book;
    private LocalDate date;

    public Reservation(User user, Book book, LocalDate date) {
        this.user = user;
        this.book = book;
        this.date = date;
    }

    // getters...
}
