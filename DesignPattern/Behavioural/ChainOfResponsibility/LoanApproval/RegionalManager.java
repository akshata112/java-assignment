package DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval;

import DesignPattern.Behavioural.ChainOfResponsibility.Loan;

public class RegionalManager implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public void processLoan(Loan loan) {
        if (loan.getAmount() <= 25000) {
            System.out.println("Regional Manager");
            System.out.println("Regional Manager approved the loan.");
        } else if (nextApprover != null) {
            System.out.print("Regional Manager -->  ");
            nextApprover.processLoan(loan);
        } else {
            System.out.println("Regional Manager");
            System.out.println("Loan approval beyond Regional Manager's limit.");
        }
    }
}