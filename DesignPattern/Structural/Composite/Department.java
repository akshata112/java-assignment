package DesignPattern.Structural.Composite;
import java.util.*;

public class Department implements Employee{
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name){
        this.name=name;
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }
    public void removeEmployee(Employee emp){
        employees.remove(emp);
    }

    public double getExpenses(){
        double totalExpense=0;
        for(Employee emp:employees){
            totalExpense+=emp.getExpenses();
        }
        return totalExpense;
    }
    
    public Set<String> getProjects(){
        Set<String> projectList=new HashSet<>();
        for(Employee emp:employees){
            projectList.addAll(emp.getProjects());
        }
        return projectList;
    }

    @Override
    public String toString() {
        return "Department [name=" + name + ", employees=" + employees + "]";
    }

    
}
