package DesignPattern.Structural.Composite;
import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        enum Choices {Employee, Department, Information, Display, Exit};

        System.out.println("Let us create company structure for EI.");
        Department company=new Department("EI");
        while (true) {
            System.out.println("Enter if you wish to create Individual Employee/Departemnt.");
            System.out.print("1.Employee\n2.Department\n3.Display\n4.Exit\nChoice:");
            String mychoice=sc.next();
            Choices userChoice;
            try {
                userChoice=Choices.valueOf(mychoice);
            } catch (Exception e) {
                System.out.println("Invalid Choice.");
                continue;
            }

            switch (userChoice) {
                case Employee:
                    System.out.println("Creating Individual Employee");
                    company.addEmployee(createEmployee());
                    break;

                case Department:
                    sc.nextLine();
                    System.out.print("Enter name of the Department: ");
                    String depName = sc.nextLine();
                    Department dep = new Department(depName);
            
                    System.out.print("Enter number of employees to be added in the department: ");
                    int depSize = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Adding Employees to the "+depName+" department.");
                    for(int i=0;i<depSize;i++){
                        dep.addEmployee(createEmployee());
                    }
                    company.addEmployee(dep);
                    break;

                case Display:
                    System.out.println("Total Company Expenses is "+company.getExpenses());
                    System.out.println("On going projects: "+company.getProjects());
                    System.out.println("\n Company Structure");
                    System.out.println(company);

                case Exit:
                    return;
                    
            
                default:
                    break;
            }
        }
    }
    public static Employee createEmployee(){
        
        System.out.print("Name:");
        String name=sc.next();
        System.out.print("Role:");
        String role=sc.next();
        System.out.print("Salary:");
        double salary=sc.nextDouble();
        System.out.print("Number of projects they are working on:");
        int projectCount=sc.nextInt();
        sc.nextLine();
        Set<String> projects=new HashSet<>();
        System.out.println("Project names:");
        for(int i=0;i<projectCount;i++){
            projects.add(sc.nextLine());
        }
        return new IndividualEmp(name, role, salary, projects);        
    }
}
