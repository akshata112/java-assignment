package Builder;

public class AccountBuilder implements Builder{

    public AccountBuilder(){
        this.object=new BankAccount();
    }

    private BankAccount object;

    public Builder setAccounttype(String accounttype){
        object.accountType=accounttype;
        return this;
    }
    public Builder setCurrency(String currency){
        object.currency=currency;
        return this;
    }
    public Builder setUpiAccount(String upi){
        object.onlineBanking=upi;
        return this;
    }
    public Builder setAdditionalServices(String additionalServices){
        object.additionalServices=additionalServices;
        return this;
    }

    public BankAccount build(){
        return object;
    }
}
