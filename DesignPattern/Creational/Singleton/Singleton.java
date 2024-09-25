import java.util.Scanner;
final class SingletonObj{
    public String name;
    static private SingletonObj object;

    Scanner sc=new Scanner(System.in);
    private SingletonObj(){
        System.err.print("Enter the name for Master Branch:");
        this.name=sc.nextLine();
        System.err.println("Master branch created.");
    }

    public static SingletonObj getMasterBranch(){
        if(object!=null){
            return object;
        }
        synchronized(SingletonObj.class){
            if(object==null){
                object=new SingletonObj();
            }
            else{
                System.out.println("Master branch already created.");
            }
            return object;
        }
    }
}

public class Singleton{
        public static void main(String[] args){
        Thread first=new Thread(new firstThread());
        Thread second =new Thread(new secondThread());
        first.run();
        second.run();

    }

    static class firstThread implements Runnable {
        public void run(){
            SingletonObj first=SingletonObj.getMasterBranch();
            System.out.println("Master Branch "+first.name);
        }
        
    }

    static class secondThread implements Runnable {
        public void run(){
            SingletonObj second=SingletonObj.getMasterBranch();
            System.out.println("Master Branch "+second.name);
        }
        
    }

}
