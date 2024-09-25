package AbstractFactory.builder;

import AbstractFactory.content.content;
import AbstractFactory.content.htmlcontent;
import AbstractFactory.pkg_footer.footer;
import AbstractFactory.pkg_footer.htmlfooter;
import AbstractFactory.pkg_header.header;
import AbstractFactory.pkg_header.htmlheader;


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

