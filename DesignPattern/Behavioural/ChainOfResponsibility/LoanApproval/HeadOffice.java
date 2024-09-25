package DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval;

import DesignPattern.Behavioural.ChainOfResponsibility.Loan;

public class HeadOffice implements LoanApprover {
    @Override
    public void setNextApprover(LoanApprover nextApprover) {
        throw new UnsupportedOperationException("Head Office does not have a next approver.");
    }

    @Override
    public void processLoan(Loan loan) {
        System.out.println("Head Office");
        System.out.println("Head Office approved the loan.");
    }
}