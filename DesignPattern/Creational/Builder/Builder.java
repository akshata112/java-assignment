package Builder;

public interface Builder {
    Builder setAccounttype(String accounttype);
    Builder setCurrency(String currency);
    Builder setUpiAccount(String upi);
    Builder setAdditionalServices(String additionalServices);
    BankAccount build();
    
}
