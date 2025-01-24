package main.java.com.library.users;

import main.java.com.library.policies.LoanPolicy;
import main.java.com.library.policies.PostgradLoanPolicy;

public class PostgradStudent extends User {
    private LoanPolicy loanPolicy = new PostgradLoanPolicy();

    public PostgradStudent(int code, String name) {
        super(code, name);
    }

    @Override
    public LoanPolicy getLoanPolicy() {
        return loanPolicy;
    }
}