package com.epam.stax;

/**
 * Created by Nikita_Zenchyk on 2/17/2017.
 */
public enum MenuTagName {
    NAME,
    PRICE,
    SPECIFICATION,
    PORTION,
    UNIT,
    PHOTOURL,
    DESCRIPTION,
    COLD_SNACKS,
    HOT_SNACKS,
    BREAKFASTS,
    SALADS,
    SOUPS,
    FISH_DISHES,
    MEET_DISHES,
    DISHESONTHEGRILL,
    FROMTHECHEF,
    ATTACHMENT,
    DESERT,
    MENU_MENU;

    public static MenuTagName getElementTagName(String element) {
        switch (element) {
            case "unit":
                return UNIT;
            case "price":
                return PRICE;
            case "specification":
                return SPECIFICATION;
            case "description":
                return DESCRIPTION;
            case "photoUrl":
                return PHOTOURL;
            case "portion":
                return PORTION;
            case "name":
                return NAME;
            case "cold-snacks":
                return COLD_SNACKS;
            case "hot-snacks":
                return HOT_SNACKS;
            case "breakfasts":
                return BREAKFASTS;
            case "salads":
                return SALADS;
            case "soups":
                return SOUPS;
            case "fish-Dishes":
                return FISH_DISHES;
            case "meet-Dishes":
                return MEET_DISHES;
            case "dishesOnTheGrill":
                return DISHESONTHEGRILL;
            case "fromTheChef":
                return FROMTHECHEF;
            case "attachment":
                return ATTACHMENT;
            case "desert":
                return DESERT;
            case "menu":
                return MENU_MENU;
            default:
                System.out.println(element);
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}
