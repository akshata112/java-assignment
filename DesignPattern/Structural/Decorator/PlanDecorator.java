package DesignPattern.Structural.Decorator;

public abstract class PlanDecorator implements Recharge{
    Recharge recharge;
    
    public PlanDecorator(Recharge recharge){
        this.recharge=recharge;
    }

    public void setPlan(String description){
        recharge.setPlan(description);
    }

    public void setCost(double cost){
        recharge.setCost(cost);
    }

    public String getPlan(){
        return recharge.getPlan();
    }

    public double getCost(){
        return recharge.getCost();
    }


}
