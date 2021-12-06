package logic;

import java.io.File;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Файл с продавцами:
 * •	ID продавца
 * •	Фамилия продавца
 * •	Имя продавца
 */
public class Seller implements Comparable<Seller>{
    private int ID; // ID продавца
    private String surname; // Фамилия продавца
    private String name; // Имя продавца

    @JsonIgnore
    private int quantityOfSoldProduct; // количество проданных товаров

    public Seller() {
    }

    public Seller(int ID, String surname, String name) {
        this.ID = ID;
        this.surname = surname;
        this.name = name;
    }

    @Override
    public int compareTo(Seller seller) {
        Integer int1 = Integer.valueOf(this.quantityOfSoldProduct);
        Integer int2 = Integer.valueOf(seller.quantityOfSoldProduct);
        return int1.compareTo(int2);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "ID=" + ID +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", quantityOfSoldProduct=" + quantityOfSoldProduct +
                '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfSoldProduct() {
        return quantityOfSoldProduct;
    }

    public void setQuantityOfSoldProduct(int quantityOfSoldProduct) {
        this.quantityOfSoldProduct = quantityOfSoldProduct;
    }


}
