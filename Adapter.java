import java.util.Scanner;

interface WeightMachine {
    void setWeightInKg(int weight);
    int getWeightInKg();
}

class WeightMachineImpl implements WeightMachine {
    private int weightInKg;

    @Override
    public void setWeightInKg(int weight) {
        this.weightInKg = weight;
    }

    @Override
    public int getWeightInKg() {
        return weightInKg;
    }
}

interface WeightMachineAdapter {
    double getWeightInPounds();
}

class WeightMachineAdapterImpl implements WeightMachineAdapter {
    private WeightMachine machine;

    public WeightMachineAdapterImpl(WeightMachine machine) {
        this.machine = machine;
    }

    @Override
    public double getWeightInPounds() {
        double pound=2.2;
        return machine.getWeightInKg() * pound;
    }
}

public class Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WeightMachine machine = new WeightMachineImpl();

        System.out.println("Let's set the weight in Kg initially.");
        System.out.print("Enter weight in kg: ");
        int weight = scanner.nextInt();

        machine.setWeightInKg(weight);

        System.out.println("If user wish to get weight in pounds(1:Yes / 0:No):");
        int choice = scanner.nextInt();
        if (choice==1){
            WeightMachineAdapter adapter = new WeightMachineAdapterImpl(machine);

            System.out.println("Weight in Kg: " + machine.getWeightInKg());
            System.out.println("Weight in Pounds: " + adapter.getWeightInPounds());
        }


        scanner.close();
    }
}