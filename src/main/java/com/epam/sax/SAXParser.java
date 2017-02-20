package com.epam.sax;

import com.epam.bean.Unit;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Nikita_Zenchyk on 2/16/2017.
 */
public class SAXParser{

    public List<Unit> pars() throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("menu.xsd.xml"));

        List<Unit> menu = handler.getUnitList();

        return menu;
    }
}
