package DesignPattern.Structural.Decorator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        enum addData {YES,NO};
        enum up5G {YES,NO};
        String[][] plans={
            {"30 days: unlimited calls and SMS with 10 GB data","100.0"},
            {"60 days: unlimited calls and SMS with 10 GB data","200.0"},
            {"90 days: unlimited calls and SMS with 10 GB data","300.0"},
        };
        System.out.println("Available plans:");
        for(int i=0;i<3;i++){
            System.out.println(i+1+" "+plans[i][0]+" Cost:"+plans[i][1]);
        }
        System.out.print("Choose basic plan:");
        int basic=sc.nextInt();

        addData data;
        System.out.print("If you wish to add extra 5 GB (Yes/No):");
        while(true){
            try {
                data=addData.valueOf(sc.next().toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("Invalid choice");
            }
        }

        up5G upgrade;
        System.out.print("If you wish to upgrade to 5G (Yes/No):");
        while(true){
            try {
                upgrade=up5G.valueOf(sc.next().toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("Invalid choice");
            }
        }
        PlanDecorator newPlan=null;
        if(data.equals(addData.YES) && upgrade.equals(up5G.YES)){
            newPlan=new DataAddOn(
                new Upgrade5G(
                    new BasicPlan()
                )
            ); 
        }
        else if(data.equals(addData.YES)){
            newPlan=new DataAddOn(
                new BasicPlan()
            );
        }
        else if(upgrade.equals(up5G.YES)){
            newPlan=new Upgrade5G(
                new BasicPlan()
            );
        }
        else{
            BasicPlan basicOnly=new BasicPlan();
            basicOnly.setPlan(plans[basic-1][0]);
            basicOnly.setCost(Double.valueOf(plans[basic-1][1]));
            System.out.println("\nYour new Plan.");
            System.out.println(basicOnly.getPlan());
            System.out.println("Total cost:"+basicOnly.getCost());
        }

        if(newPlan!=null){
            newPlan.setPlan(plans[basic-1][0]);
            newPlan.setCost(Double.valueOf(plans[basic-1][1]));

            System.out.println("\nYour new Plan.");
            System.out.println(newPlan.getPlan());
            System.out.println("Total cost:"+newPlan.getCost());
        }

        sc.close();
        
    }
}
