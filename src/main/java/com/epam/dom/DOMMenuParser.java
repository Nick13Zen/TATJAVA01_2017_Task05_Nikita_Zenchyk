package com.epam.dom;

import com.epam.bean.Unit;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita_Zenchyk on 2/17/2017.
 */
public class DOMMenuParser {

    public static List<Unit> startParser() {

        DOMParser parser = new DOMParser();
        try {
            parser.parse("menu.xsd.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document document = parser.getDocument();

        Element root = document.getDocumentElement();

        List<Unit> menu = new ArrayList();

        NodeList foodNodes = root.getElementsByTagName("unit");
        Unit unit;
        for (int i = 0; i < foodNodes.getLength(); i++) {
            unit = new Unit();
            Element foodElement = (Element) foodNodes.item(i);
            unit.setPhotourl(getSingleChild(foodElement, "photoUrl").getTextContent().trim());
            unit.setName(getSingleChild(foodElement, "name").getTextContent().trim());
            unit.setSpecification(getSingleChild(foodElement, "specification").getTextContent().trim());
            unit.setPortion(getSingleChild(foodElement, "portion").getTextContent().trim());
            unit.setPrice(Double.parseDouble(getSingleChild(foodElement, "price").getTextContent().trim()));
            menu.add(unit);
        }
        return menu;
    }

    private static Element getSingleChild(Element element, String chiledName) {
        NodeList nlist = element.getElementsByTagName(chiledName);
        Element child = (Element) nlist.item(0);
        return child;
    }
}