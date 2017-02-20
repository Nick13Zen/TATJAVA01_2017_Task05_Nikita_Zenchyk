package com.epam.stax;

import com.epam.bean.Unit;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita_Zenchyk on 2/17/2017.
 */
public class StAXMenuParser {

    public static List<Unit> process(XMLStreamReader reader) throws XMLStreamException {
        List<Unit> menu = new ArrayList<>();
        Unit unit = null;
        MenuTagName elemantName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLSteramConstants.START_ELEMENT:
                    elemantName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elemantName) {
                        case UNIT:
                            unit = new Unit();
                            break;
                    }
                    break;
                case XMLSteramConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elemantName) {
                        case NAME:
                            unit.setName(text);
                            break;
                        case PRICE:
                            unit.setPrice(Double.parseDouble(text));
                            break;
                        case SPECIFICATION:
                           unit.setSpecification(text);
                            break;
                        case PORTION:
                            unit.setPortion(text);
                            break;
                        case PHOTOURL:
                            unit.setPhotourl(text);
                            break;
                    }
                    break;
                case XMLSteramConstants.END_ELEMENT:
                    elemantName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elemantName) {
                        case UNIT:
                            menu.add(unit);
                    }
            }
        }
        return menu;
    }
}