package logic;

/**
 * Файл с товарами:
 * •	ID товара
 * •	Наименование товара
 */


public class Product {
    int ID_product; // ID товара
    String name; // Наименование товара

    public Product(int ID_product, String name) {
        this.ID_product = ID_product;
        this.name = name;
    }

    public Product() {
    }

    public int getID_product() {
        return ID_product;
    }

    public void setID_product(int ID_product) {
        this.ID_product = ID_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID_product=" + ID_product +
                ", name='" + name + '\'' +
                '}';
    }
}
