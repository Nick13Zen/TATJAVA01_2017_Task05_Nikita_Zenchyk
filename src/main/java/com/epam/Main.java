package com.epam;


import com.epam.bean.Unit;
import com.epam.dom.DOMMenuParser;
import com.epam.sax.SAXStartParser;
import com.epam.stax.StAXStartParser;

import java.util.Formatter;
import java.util.List;


/**
 * Created by Nikita_Zenchyk on 2/16/2017.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("SAXParser");
        System.out.println("--------------------------------------------");
        System.out.println(prepareToPrint(SAXStartParser.startParser()));

        System.out.println("StAXParser");
        System.out.println("--------------------------------------------");
        System.out.println(prepareToPrint(StAXStartParser.startParser()));

        System.out.println("DOMParser");
        System.out.println("--------------------------------------------");
        System.out.println(prepareToPrint(DOMMenuParser.startParser()));
    }

    private static Formatter prepareToPrint(List<Unit> menu) {
        Formatter formatter = new Formatter();
        for (Unit unit : menu) {
            formatter.format("|%-1s|%-1s|%-1s|%-1s|\n", unit.getPhotourl(), unit.getName(), unit.getSpecification(), unit.getPortion(), unit.getPrice());
        }
        return formatter;
    }
}
