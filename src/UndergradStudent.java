import instances.User;

import interfaces.ILoanPolicy;

public class UndergradStudent extends User {
    private ILoanPolicy loanPolicy = new UndergradLoanPolicy(); // poderia ser singleton tb

    public UndergradStudent(int code, String name) {
        super(code, name);
    }

    @Override
    public ILoanPolicy getLoanPolicy() {
        return loanPolicy;
    }
}