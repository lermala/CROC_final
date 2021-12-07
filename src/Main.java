import logic.General;
import logic.Seller;
import work_with_data.JSONClass;
import work_with_data.XMLClass;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Вариант 10
 * 4 Вывести в файл топ 5 продавцов, продавших наибольшее количество товаров
 * 1 Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
 * 2 (вход) JSON,	(выход) XML
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // 1. вызываем класс для считывания данных (из папки data)
        // data/sales.json, data/products.json, data/sellers.json, data/sellersProducts.json
        JSONClass parsingClass = new JSONClass();
        // parsingClass.createStartFile(); // создаем и наполняем файлы, если их не существует
        parsingClass.readData(); // считываем данные из JSON файлов

        // 2. вносим считанные данные в класс для работы
        General general = new General(parsingClass.getSellers(),
                parsingClass.getProducts(),
                parsingClass.getSellersProducts(),
                parsingClass.getSales()
        );

        // 3. считаем топ продавцов и топ дат
        List<Seller> topSellers = general.getTopSellers(5);// задание 1
        List<Map.Entry<Date, Integer>> topDates = general.getTopDates(5);// задание 2

        // 4. вызываем класс для работы с записью данных в XML файл и записываем посчитанные данные в файлы
        // по итогу выходят файлы data/dates_info.xml и data/sellers_info.xml
        XMLClass xmlClass = new XMLClass();
        xmlClass.writeSellersToXML(topSellers); // задание 1
        xmlClass.writeDatesToXML(topDates); // задание 2
    }
}
