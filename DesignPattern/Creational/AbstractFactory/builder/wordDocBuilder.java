package AbstractFactory.builder;
import AbstractFactory.content.wordcontent;
import AbstractFactory.pkg_footer.footer;
import AbstractFactory.pkg_footer.wordfooter;
import AbstractFactory.pkg_header.header;
import AbstractFactory.pkg_header.wordheader;
import AbstractFactory.content.content;

public class wordDocBuilder implements documentBuilder{
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
