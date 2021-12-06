package logic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.Date;

/**
 * Файл с продажами:
 * •	ID продажи
 * •	ID продавца
 * •	ID товара
 * •	Количество проданных товаров
 * •	Дата продажи
 */

public class Sale {
    int ID_sale; // ID продажи
    int ID_product; // ID товара
    int ID_seller; // ID продавца
    int quantityOfSoldProducts; // Количество проданных товаров

    Date dateOfSale; // дата продажи

    public Sale(int ID_sale, int ID_product, int ID_seller, int quantityOfSoldProducts, Date dateOfSale) {
        this.ID_sale = ID_sale;
        this.ID_product = ID_product;
        this.ID_seller = ID_seller;
        this.quantityOfSoldProducts = quantityOfSoldProducts;
        this.dateOfSale = dateOfSale;
    }

    public Sale() {
    }

    public int getID_sale() {
        return ID_sale;
    }

    public int getID_product() {
        return ID_product;
    }

    public int getID_seller() {
        return ID_seller;
    }

    public int getQuantityOfSoldProducts() {
        return quantityOfSoldProducts;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setID_sale(int ID_sale) {
        this.ID_sale = ID_sale;
    }

    public void setID_product(int ID_product) {
        this.ID_product = ID_product;
    }

    public void setID_seller(int ID_seller) {
        this.ID_seller = ID_seller;
    }

    public void setQuantityOfSoldProducts(int quantityOfSoldProducts) {
        this.quantityOfSoldProducts = quantityOfSoldProducts;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "ID_sale=" + ID_sale +
                ", ID_product=" + ID_product +
                ", ID_seller=" + ID_seller +
                ", quantityOfSoldProducts=" + quantityOfSoldProducts +
                ", dateOfSale=" + dateOfSale +
                '}';
    }
}
