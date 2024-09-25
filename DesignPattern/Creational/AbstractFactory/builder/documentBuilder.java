package AbstractFactory.builder;

import AbstractFactory.content.content;
import AbstractFactory.pkg_footer.footer;
import AbstractFactory.pkg_header.header;

public interface documentBuilder {
    header defineHeader();
    content defineContent();
    footer defineFooter();
}


