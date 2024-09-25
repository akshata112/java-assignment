package DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval;

import DesignPattern.Behavioural.ChainOfResponsibility.Loan;

public interface LoanApprover {
    void processLoan(Loan loan);
    void setNextApprover(LoanApprover nextApprover);
}
