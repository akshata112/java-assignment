package Builder;

public class Main {
    public static void main(String[] args) {
        Builder build=new AccountBuilder();
        BankAccount acc1=build.setAccounttype("Savings")
                        .setCurrency("INR")
                        .setUpiAccount("abc@paytm")
                        .setAdditionalServices("None")
                        .build();
        System.out.println(acc1);
        BankAccount build1=new AccountBuilder().setAccounttype("Saving").build();
        System.out.println(build1);
    }
}
//Mandatory type of paramters for each object