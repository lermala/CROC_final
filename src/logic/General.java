package logic;

import java.util.*;

// 4	Вывести в файл топ 5 продавцов, продавших наибольшее количество товаров
// 1	Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
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

    // Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
    public void getTopDates(int top){
        // for every date
        // count quantity of product

        //Map<Date, int> dateMap = new Ma

        List<DateInfo> dateInfos = new ArrayList<>();
        for (Sale s: sales) {
            dateInfos.add(new DateInfo(s.getDateOfSale()));
        }

        Set<DateInfo> dateInfoSet = new HashSet<>();
        for (Sale s: sales) {
            dateInfoSet.add(new DateInfo(s.getDateOfSale()));
        }

        System.out.println("List:" + dateInfos.size());
        //dateInfos.stream().forEach(x -> System.out.println(x.toString()));

        System.out.println("Set:" + dateInfoSet.size());
        //dateInfoSet.stream().forEach(x -> System.out.println(x.toString()));


        Date d1 = new Date();
        System.out.println(d1);
    }

    /**
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
