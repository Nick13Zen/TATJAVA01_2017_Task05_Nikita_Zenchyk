package com.epam.stax;

import com.epam.bean.Unit;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static com.epam.stax.StAXMenuParser.process;

/**
 * Created by Nikita_Zenchyk on 2/17/2017.
 */
public class StAXStartParser {
    public static List<Unit> startParser() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        List<Unit> menu = null;
        try {
            InputStream inputStream = new FileInputStream("menu.xsd.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            menu = process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return menu;
    }
}
