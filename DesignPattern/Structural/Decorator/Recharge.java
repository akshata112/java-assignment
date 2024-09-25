package DesignPattern.Structural.Decorator;

public interface Recharge {
    public void setPlan(String description);
    public void setCost(double cost);
    public String getPlan();
    public double getCost();
}
