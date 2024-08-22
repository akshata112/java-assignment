package AbstractFactory;

class htmlfooter implements footer{
    public void addFooter(){
        System.out.println("Adding footer to HTML document.");
    }
}


class wordfooter implements footer{
    public void addFooter(){
        System.out.println("Adding footer to word document.");
    }
}
