package AbstractFactory;

class htmlcontent implements content{
    public void addContent(){
        System.out.println("Adding html content into document.");
    }
}

class wordcontent implements content{
    public void addContent(){
        System.out.println("Adding word content into document.");
    }
}
