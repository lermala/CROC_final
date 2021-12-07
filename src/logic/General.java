package logic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для работы с множествами объектов классов Seller, Product, SellersProduct, Sale.
 */
public class General {
    private List<Seller> sellers;
    private List<Product> products;
    private List<SellersProduct> sellersProducts;
    private List<Sale> sales;

    public General(List<Seller> sellers, List<Product> products, List<SellersProduct> sellersProducts, List<Sale> sales) {
        this.sellers = sellers;
        this.products = products;
        this.sellersProducts = sellersProducts;
        this.sales = sales;
    }

    /**
     * ЗАДАНИЕ 1
     * заданное количество (топ) продавцов, продавших наибольшее количество товаров
     * @param top - количество лучших продавцов, которых нужно вывести
     * @return список лучших продавцов
     */
    public List<Seller> getTopSellers(int top) throws Exception {
        if (top > sellers.size()) throw new Exception("the number of sellers is less than the value of the top number");

        List<Seller> topSellers = new ArrayList<>();

        for (Seller seller: sellers) {
            int quantity = getQuantityOfSoldProduct(getSalesForSeller(seller)); // считаем кол-во продаж
            seller.setQuantityOfSoldProduct(quantity); // устанавливаем значение для последующей сортировки
        }

        // здесь сортируем продавцов по возрастанию кол-ва продаж
        Collections.sort(sellers, Collections.reverseOrder (new Comparator<Seller>() {
            @Override
            public int compare(Seller o1, Seller o2) {
                return o1.compareTo(o2);
            }
        }));

        topSellers = sellers.subList(0, top); // получаем топ продавцов

        return topSellers;
    }

    /**
     * ЗАДАНИЕ 2
     * Функция находит топ дат, в которые было продано наибольшее количество товаров
     * @param top количество дат, которые нужно вывести
     * @return топ дат, в которые было продано наибольшее количество товаров
     */
    public List<Map.Entry<Date, Integer>> getTopDates(int top){
        Map<Date, Integer> dateMap = new HashMap<>();
        // сначала смотрим, какие есть даты и вносим их как ключи
        for (Sale s: sales) {
            dateMap.put(s.getDateOfSale(), 0);
        }

        // теперь считаем для каждой даты кол-во продаж
        for (Sale s: sales) {
            for(Map.Entry<Date, Integer> item : dateMap.entrySet()){
                if (s.getDateOfSale().getTime() == item.getKey().getTime()){ // если даты соответствуют
                    Integer count = item.getValue() + s.getQuantityOfSoldProducts(); // считаем кол-во
                    System.out.println(item.getKey().getTime() + " val=" + item.getValue() + " sold=" + s.getQuantityOfSoldProducts() + " count=" + count);
                    item.setValue(count); // устанавливаем новое значение проданных товаров
                }
            }
        }

        // перебор элементов
        //System.out.println("sales: " + sales.size());
        //System.out.println("Perebor: " + dateMap.size());
        //for(Map.Entry<Date, Integer> item : dateMap.entrySet()){
        //   // System.out.println(item.getKey() + " " + item.getValue());
        //}

        // теперь сортируем по кол-ву продаж
        List<Map.Entry<Date, Integer>> topDates = dateMap.entrySet().stream()
                .sorted(Map.Entry.<Date, Integer>comparingByValue().reversed())
                .limit(top)
                //.collect(Collectors.toList())
                //.collect(Collectors.toMap(d -> d.getKey(), i -> i.getValue()))
                .collect(Collectors.toList())
                //.forEach(System.out::println);
                ;

        topDates.forEach(System.out::println);

        return topDates;
    }

    /**
     * Получение всех продаж для определенного продавца
     * @param seller - продавец, для которого ищем всем продажи
     * @return список продаж продавца
     */
    public List<Sale> getSalesForSeller(Seller seller){
        List<Sale> sellerSales = new ArrayList<>();
        for (Sale sale: sales) {
            if (sale.getID_seller() == seller.getID()){
                sellerSales.add(sale);
            }
        }
        return sellerSales;
    }

    /**
     * Возвращает количество проданных товаров среди продаж.
     * @param sales - продажи, среди которых ищем количество проданных товаров
     * @return количество проданных товаров
     */
    public int getQuantityOfSoldProduct(List<Sale> sales){
        int quantity = 0;
        for (Sale sale: sales) {
            quantity += sale.getQuantityOfSoldProducts();
        }

        return quantity;
    }
}
