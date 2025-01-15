package Modelle;

import java.util.List;

public class Mrdikanemte {
    private String name;
    private int price;
    private String krankheit;

    public Mrdikanemte(String krankheit, String name, int price) {
        this.krankheit = krankheit;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKrankheit() {
        return krankheit;
    }

    public void setKrankheit(String krankheit) {
        this.krankheit = krankheit;
    }

    @Override
    public String toString() {
        return "Mrdikanemte{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", krankheit='" + krankheit + '\'' +
                '}';
    }
}
