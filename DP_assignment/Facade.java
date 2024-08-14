import java.util.Scanner;
class ACExternalUnit {
    public void checkVoltage() {
        System.out.println("Checking voltage...");
    }

    public void consumeNitrogen() {
        System.out.println("Consuming nitrogen...");
    }

    public void startCondenser() {
        System.out.println("Starting condenser...");
    }
}

class ACInternalUnit {
    public void acceptUserTempCmd() {
        System.out.println("Accepting user temperature command...");
    }
}

class ACFacade {
    private ACExternalUnit externalUnit;
    private ACInternalUnit internalUnit;

    public ACFacade() {
        externalUnit = new ACExternalUnit();
        internalUnit = new ACInternalUnit();
    }

    public void turnOnButtonClicked() {
        internalUnit.acceptUserTempCmd();
        externalUnit.checkVoltage();
        externalUnit.consumeNitrogen();
        externalUnit.startCondenser();
        System.out.println("AC is turned On.");
    }

    public void turnOffButtonClicked(){
        System.out.println("AC is turned off.");
    }

}

class Facade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ACFacade acFacade = new ACFacade();
        System.out.println("If user wish to switch on/off AC(1:On / 0:Off):");
        int choice = scanner.nextInt();
        if(choice==1){
            acFacade.turnOnButtonClicked();
        }
        else if(choice==0){
            acFacade.turnOffButtonClicked();
        }
        else{
            System.out.println("Invalid Choice");
            scanner.close();
        }

    }
}
