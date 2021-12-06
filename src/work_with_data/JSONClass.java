package work_with_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Product;
import logic.Sale;
import logic.Seller;
import logic.SellersProduct;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JSONClass {
    // JSON файлы для хранения данных
    private File fileSellers = new File("data/sellers.json");
    private File fileProducts = new File("data/products.json");
    private File fileSales = new File("data/sales.json");
    private File fileSellersProducts = new File("data/sellersProducts.json");

    private List<Product> products;
    private List<Sale> sales;
    private List<Seller> sellers;
    private List<SellersProduct> sellersProducts;

    public JSONClass() {

    }

    /**
     * Создание JSON файлов с заполненными данными по всем классам.
     */
    public void createStartFiles(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // генерируем данные
            DataGenerator dataGenerator = new DataGenerator();
            List<Seller> sellers = dataGenerator.generateSellers(10);
            List<Product> products = dataGenerator.generateProducts(50);
            List<SellersProduct> sellersProducts = dataGenerator.generateSellersProducts(100);
            List<Sale> sales = dataGenerator.generateSales(100);

            // заполняем файлы данными
            mapper.writeValue(fileSellers, sellers);
            mapper.writeValue(fileProducts, products);
            mapper.writeValue(fileSales, sales);
            mapper.writeValue(fileSellersProducts, sellersProducts);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readData(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // считываем Java объекты из JSON файлов
            products = Arrays.asList(mapper.readValue(fileProducts, Product[].class));
            sales = Arrays.asList(mapper.readValue(fileSales, Sale[].class));
            sellers = Arrays.asList(mapper.readValue(fileSellers, Seller[].class));
            sellersProducts = Arrays.asList(mapper.readValue(fileSellersProducts, SellersProduct[].class));

            // products.stream().forEach(x -> System.out.println(x));
            // sales.stream().forEach(x -> System.out.println(x));
            // sellers.stream().forEach(x -> System.out.println(x));
            // sellersProducts.stream().forEach(x -> System.out.println(x));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    public List<Product> getProducts() {
        return products;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public List<SellersProduct> getSellersProducts() {
        return sellersProducts;
    }
}
