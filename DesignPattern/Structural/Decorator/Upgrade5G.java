package DesignPattern.Structural.Decorator;

public class Upgrade5G extends PlanDecorator{
    public Upgrade5G(Recharge recharge) {
        super(recharge);
    }

    public void setPlan(String description){
        super.setPlan(description+"\nUpgrade to 5G added.");
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
