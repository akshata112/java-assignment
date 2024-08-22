package Builder;

class BankAccount {
    String accountType;
    String currency;
    String onlineBanking;
    String additionalServices;

    // public BankAccount(String accountType, String currency, String onlineBanking, String additonalServices){
    //     this.accountType=accountType;
    //     this.currency=currency;
    //     this.onlineBanking=onlineBanking;
    //     this.additionalServices=additonalServices;
    // }

    public String getaccountType(){
        return accountType;
    }

    public String getcurrency(){
        return currency;
    }

    public String getonlineBanking(){
        return onlineBanking;
    }

    public String getAdditionalService(){
        return additionalServices;
    }

    @Override
    public String toString() {
        return "BankAccount [accountType=" + accountType + ", currency=" + currency + ", onlineBanking=" + onlineBanking
                + ", additionalServices=" + additionalServices + "]";
    }

    // public String toString(){
    //     return "New bank account created.\nAccount Type:"+accountType;
    // }
}
