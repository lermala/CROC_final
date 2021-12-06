import logic.General;
import work_with_data.JSONClass;

public class Controller {

    public void start(){
        // 1. вызываем класс для считывания данных
        JSONClass parsingClass = new JSONClass();
        // parsingClass.createStartFile(); // создаем и наполняем файлы, если их не существует
        parsingClass.readData(); // считываем данные из JSON файлов

        // 2. вносим считанные данные в класс для работы
        General general = new General(parsingClass.getSellers(),
                parsingClass.getProducts(),
                parsingClass.getSellersProducts(),
                parsingClass.getSales()
                );


    }
}