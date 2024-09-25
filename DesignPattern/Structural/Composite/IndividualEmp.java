package DesignPattern.Structural.Composite;
import java.util.*;

public class IndividualEmp implements Employee{
    private String name;
    private String role;
    private double expense;
    private Set<String> projects;

    public IndividualEmp(String name,String role,double expense,Set<String> projects){
        this.name=name;
        this.role=role;
        this.expense=expense;
        this.projects=projects;
    }

    public double getExpenses(){
        return expense;
    }

    public Set<String> getProjects(){
        return projects;
    }

    @Override
    public String toString() {
        return "IndividualEmp [name=" + name + ", role=" + role + ", expense=" + expense + ", projects=" + projects
                + "]";
    }

    
}
