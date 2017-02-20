package com.epam.bean;

/**
 * Created by Nikita_Zenchyk on 2/16/2017.
 */
public class Unit {

    private String photourl;
    private String name;
    private String specification;
    private String portion;
    private double price;

    @Override
    public String toString() {
        return
                photourl + ' ' + name + ' ' + specification + ' ' + portion + ' ' + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (Double.compare(unit.price, price) != 0) return false;
        if (photourl != null ? !photourl.equals(unit.photourl) : unit.photourl != null) return false;
        if (name != null ? !name.equals(unit.name) : unit.name != null) return false;
        if (specification != null ? !specification.equals(unit.specification) : unit.specification != null)
            return false;
        return portion != null ? portion.equals(unit.portion) : unit.portion == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = photourl != null ? photourl.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        result = 31 * result + (portion != null ? portion.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Unit() {
        this.photourl = "";
        this.name = "";
        this.specification = "";
        this.portion = "";

    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion
    ) {
        this.portion = portion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
