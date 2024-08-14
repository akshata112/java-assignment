interface LoanApprover {
    void processLoan(Loan loan);
    void setNextApprover(LoanApprover nextApprover);
}

class Loan {
    private double amount;

    public Loan(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class BranchManager implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processLoan(Loan loan) {
        if (loan.getAmount() <= 10000) {
            System.out.println("Branch Manager approved the loan.");
        } else if (nextApprover != null) {
            nextApprover.processLoan(loan);
        } else {
            System.out.println("Loan approval beyond Branch Manager's limit.");
        }
    }
}

class RegionalManager implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processLoan(Loan loan) {
        if (loan.getAmount() <= 25000) {
            System.out.println("Regional Manager approved the loan.");
        } else if (nextApprover != null) {
            nextApprover.processLoan(loan);
        } else {
            System.out.println("Loan approval beyond Regional Manager's limit.");
        }
    }
}

class HeadOffice implements LoanApprover {
    @Override
    public void setNextApprover(LoanApprover nextApprover) {
        throw new UnsupportedOperationException("Head Office does not have a next approver.");
    }

    @Override
    public void processLoan(Loan loan) {
        System.out.println("Head Office approved the loan.");
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        LoanApprover branchManager = new BranchManager();
        LoanApprover regionalManager = new RegionalManager();
        LoanApprover headOffice = new HeadOffice();

        branchManager.setNextApprover(regionalManager);
        regionalManager.setNextApprover(headOffice);

        Loan loan1 = new Loan(15000);
        branchManager.processLoan(loan1);

        Loan loan2 = new Loan(30000);
        branchManager.processLoan(loan2);

        Loan loan3 = new Loan(8000);
        branchManager.processLoan(loan3);
    }
}
