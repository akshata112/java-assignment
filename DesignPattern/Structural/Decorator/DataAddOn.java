package DesignPattern.Structural.Decorator;

public class DataAddOn extends PlanDecorator {

    
    public DataAddOn(Recharge recharge) {
        super(recharge);
    }

    public void setPlan(String description){
        super.setPlan(description+"\nExtra 5GB data added.");
    }

    public void setCost(double cost){
        super.setCost(cost+70.0);
    }

    public String getPlan(){
        return super.getPlan();
    }

    public double getCost(){
        return super.getCost();
    }

}
