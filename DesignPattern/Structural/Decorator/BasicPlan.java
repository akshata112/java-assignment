package DesignPattern.Structural.Decorator;

public class BasicPlan implements Recharge{
    private String description;
    private double cost;


    public void setPlan(String description){
        this.description=description;
    }

    public void setCost(double cost){
        this.cost=cost;
    }
    public String getPlan(){
        return description;
    }

    public double getCost(){
        return cost;
    }

}
