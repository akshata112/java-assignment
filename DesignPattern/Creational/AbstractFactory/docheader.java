package AbstractFactory;

class htmlheader implements header{
    public void addHeader(){
        System.out.println("Adding header to HTML document.");
    }
}

class wordheader implements header{
    public void addHeader(){
        System.out.println("Adding header to word document.");
    }
}
