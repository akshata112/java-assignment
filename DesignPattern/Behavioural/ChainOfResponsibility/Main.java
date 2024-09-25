package DesignPattern.Behavioural.ChainOfResponsibility;
import java.util.*;

import DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval.BranchManager;
import DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval.HeadOffice;
import DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval.LoanApprover;
import DesignPattern.Behavioural.ChainOfResponsibility.LoanApproval.RegionalManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        LoanApprover branchManager = new BranchManager();
        LoanApprover regionalManager = new RegionalManager();
        LoanApprover headOffice = new HeadOffice();

        branchManager.setNextApprover(regionalManager);
        regionalManager.setNextApprover(headOffice);

        System.out.println("Enter the required amount for the loan:");
        double amount=sc.nextDouble();
        Loan loan=new Loan(amount);
        branchManager.processLoan(loan);
        
        sc.close();
    }


}
