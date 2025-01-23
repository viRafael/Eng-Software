package instances;

import java.time.LocalDate;

public class Loan {
    private User user;
    private Exemplar exemplar;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate endDate; // se nulo, empréstimo em aberto

    public Loan(User user, Exemplar exemplar, LocalDate startDate, LocalDate dueDate) {
        this.user = user;
        this.exemplar = exemplar;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    // getters e setters...
}
