package main.java.com.library.users;

import main.java.com.library.policies.LoanPolicy;
import main.java.com.library.policies.UndergradLoanPolicy;

public class UndergradStudent extends User {
    private LoanPolicy loanPolicy = new UndergradLoanPolicy();

    public UndergradStudent(int code, String name) {
        super(code, name);
    }

    @Override
    public LoanPolicy getLoanPolicy() {
        return loanPolicy;
    }
}
