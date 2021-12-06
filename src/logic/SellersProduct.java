package logic;

/**
 * Файл с данными по наличию товаров у продавцов:
 * •	ID продавца
 * •	ID товара
 * •	Цена товара
 * •	Количество товара в наличии у продавца
 */
public class SellersProduct {
    int ID_product; // ID товара
    int ID_seller; // ID продавца
    double price; // Цена товара
    int quantityInStock; // Количество товара в наличии у продавца

    public SellersProduct(int ID_product, int ID_seller, double price, int quantityInStock) {
        this.ID_product = ID_product;
        this.ID_seller = ID_seller;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public SellersProduct() {
    }

    public int getID_product() {
        return ID_product;
    }

    public int getID_seller() {
        return ID_seller;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setID_product(int ID_product) {
        this.ID_product = ID_product;
    }

    public void setID_seller(int ID_seller) {
        this.ID_seller = ID_seller;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "SellersProduct{" +
                "ID_product=" + ID_product +
                ", ID_seller=" + ID_seller +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
