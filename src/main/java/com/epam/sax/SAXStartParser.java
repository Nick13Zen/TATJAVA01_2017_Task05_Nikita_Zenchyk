package com.epam.sax;

import com.epam.bean.Unit;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Nikita_Zenchyk on 2/17/2017.
 */
public class SAXStartParser {
    public static List<Unit> startParser() {
        SAXParser parser = new SAXParser();
        List<Unit> menu = null;
        try {
            menu = parser.pars();
        } catch (SAXException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return menu;
    }
}
