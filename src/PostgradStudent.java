import instances.User;
import interfaces.ILoanPolicy;

public class PostgradStudent extends User {
    private ILoanPolicy loanPolicy = new PostgradLoanPolicy();

    public PostgradStudent(int code, String name) {
        super(code, name);
    }

    @Override
    public ILoanPolicy getLoanPolicy() {
        return loanPolicy;
    }
}