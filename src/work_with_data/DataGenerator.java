package work_with_data;

import logic.Product;
import logic.Sale;
import logic.Seller;
import logic.SellersProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Класс для генерации данных для классов logic/Seller, logic/Product, logic/Sale, logic/SellersProduct
 */
public class DataGenerator {
    List<Seller> sellers = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<SellersProduct> sellersProducts = new ArrayList<>();
    List<Sale> sales = new ArrayList<>();

    public DataGenerator() {
    }

    /**
     * Генерирует список продавцов
     * @param countOfGenerated - кол-во, которое нужно сгенерировать
     * @return список продавцов
     */
    public List<Seller> generateSellers(int countOfGenerated){
        for (int i = 0; i <= countOfGenerated; i++){
            sellers.add(new Seller(i, "Фамилия_" + i, "Имя_" + i));
        }
        return sellers;
    }

    /**
     * Генерирует список товаров
     * @param countOfGenerated - кол-во, которое нужно сгенерировать
     * @return список товаров
     */
    public List<Product> generateProducts(int countOfGenerated){
        for (int i = 0; i <= countOfGenerated; i++){
            products.add(new Product(i, "Наименование товара_" + i));
        }
        return products;
    }

    /**
     * Генерирует список продаж на основании созданных продавцов и товаров
     * @param countOfGenerated - кол-во, которое нужно сгенерировать
     * @return список продаж
     */
    public List<Sale> generateSales(int countOfGenerated){
        for (int i = 0; i <= countOfGenerated; i++){
            int idProduct = getRandomInt(0, products.size() - 1);
            int idSeller = getRandomInt(0, sellers.size() - 1);
            int quantityOfSoldProducts = getRandomInt(1, 50);

            sales.add(new Sale(i, idProduct, idSeller, quantityOfSoldProducts, getRandomDate()));
        }
        return sales;
    }

    /**
     * Генерирует список данных по наличию товаров у продавцов
     * @param countOfGenerated - кол-во, которое нужно сгенерировать
     * @return список данных по наличию товаров у продавцов
     */
    public List<SellersProduct> generateSellersProducts(int countOfGenerated){
        boolean flag = true;
        for (int i = 0; i <= countOfGenerated; i++){
            int idProduct = getRandomInt(0, products.size() - 1); // генерим продукт
            int idSeller = getRandomInt(0, sellers.size() - 1); // генерим продавца

            // проверка на уникальность сгенерированного продукта и продавца,
            // так как для продавца может храниться только одна запись о наличии этого продукта
            for (SellersProduct el: sellersProducts) {
                if (el.getID_product() == idProduct && el.getID_seller() == idSeller){
                    i--; // ничего не делаем и повторяем генерацию продукта и продавца
                    flag = false;
                } else { // если все ок
                    flag = true;
                }
            }

            // добавляем элемент
            if (flag) {
                double randomPrice = getRandomDouble(100, 9999);
                int randomQuantity = getRandomInt(0, 200);
                sellersProducts.add(new SellersProduct(idProduct, idSeller, randomPrice, randomQuantity));
            }
        }

        return sellersProducts;
    }

    /**
     * Генерация случайного целого числа в диапазоне от a до b
     * @param a Начальное значение диапазона - "от"
     * @param b Конечное значение диапазона - "до"
     * @return случайное число в диапазоне от a до b
     */
    public int getRandomInt(int a, int b){
        return a + (int) (Math.random() * b);
    }

    /**
     * Генерация случайного double числа в диапазоне от a до b
     * @param a Начальное значение диапазона - "от"
     * @param b Конечное значение диапазона - "до"
     * @return случайное число в диапазоне от a до b
     */
    public double getRandomDouble(double a, double b){
        return a + (Math.random() * b);
    }

    /**
     * https://www.baeldung.com/java-random-dates
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

    public Date getRandomDate(){
        long aDay = TimeUnit.DAYS.toMillis(1);
        long now = new Date().getTime();
        Date hundredYearsAgo = new Date(now - aDay * 365 * 100);
        Date tenDaysAgo = new Date(now - aDay * 10);

        return between(hundredYearsAgo, tenDaysAgo);
    }

}
