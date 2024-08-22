package AbstractFactory;

public class htmlBuilder implements documentBuilder{
    public header defineHeader(){
        return new htmlheader();
    }

    public footer defineFooter(){
        return new htmlfooter();
    }

    public content defineContent(){
        return new htmlcontent();
    }
}

class wordDocBuilder implements documentBuilder{
    public header defineHeader(){
        return new wordheader();
    }

    public footer defineFooter(){
        return new wordfooter();
    }

    public content defineContent(){
        return new wordcontent();
    }
}
