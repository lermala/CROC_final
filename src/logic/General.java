package logic;

import java.util.ArrayList;
import java.util.List;

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

    // Вывести в файл топ 5 продавцов, продавших наибольшее количество товаров

    /**
     *
     * @param TOP - количество лучших, которых нужно вывести
     * @return
     */
    public List<Seller> getTopSellers(int TOP){
        List<Seller> topSellers = new ArrayList<>();

        //List<>

        for (Seller seller: sellers) {
            int quantity = getQuantityOfSoldProduct(getSalesForSeller(seller)); // считаем кол-во продаж
            seller.setQuantityOfSoldProduct(quantity); // устанавливаем значение для последующей сортировки


        }

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
