package DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval;

import DesignPattern.Behavioural.ChainOfResponsibility.Loan;

public class BranchManager implements LoanApprover{
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
            System.out.print("Branch Manager -->  ");
            nextApprover.processLoan(loan);
        } else {
            System.out.println("Loan approval beyond Branch Manager's limit.");
        }
    }
}
