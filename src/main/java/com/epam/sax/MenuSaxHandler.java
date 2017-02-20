package com.epam.sax;

import com.epam.bean.Unit;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita_Zenchyk on 2/16/2017.
 */
public class MenuSaxHandler extends DefaultHandler {
    private List<Unit> unitList = new ArrayList<Unit>();
    private Unit unit;
    private StringBuilder text;

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("unit")) {
            unit = new Unit();
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.contains("menu:menu")) {
            qName = "menu_menu";
        }
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case PHOTOURL:
                unit.setPhotourl(text.toString());
                break;
            case NAME:
                unit.setName(text.toString());
                break;
            case PRICE:
                unit.setPrice(Double.parseDouble(text.toString()));
                break;
            case PORTION:
                unit.setPortion(text.toString());
                break;
            case UNIT:
                unitList.add(unit);
                unit = null;
                break;
            case SPECIFICATION:
                unit.setSpecification(text.toString());
                break;
        }
    }
}
