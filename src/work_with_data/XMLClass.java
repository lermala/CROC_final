package work_with_data;

import logic.Seller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class XMLClass {
    private  final  String FILE_data_dates = "data/dates_info.xml";
    private  final  String FILE_data_sellers = "data/sellers_info.xml";

    /**
     * Функция записи дат в XML файл
     * @param dates даты, которые нужно записать в файл
     */
    public void writeDatesToXML(List<Map.Entry<Date, Integer>> dates) {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder        db  = null;
        Document               doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element e_root   = doc.createElement("DatesInfo");
            e_root.setAttribute("lang", "en");
            Element e_dates  = doc.createElement("Dates");
            e_root.appendChild(e_dates);
            // doc.appendChild(e_root);

            for (Map.Entry<Date, Integer> el : dates) {
                Element e = doc.createElement("dateInfo");
                e.setTextContent(el.getKey().toString());
                e.setAttribute("quantity", el.getValue().toString());
                e.setAttribute("date_time", el.getKey().getTime() + "");
                e_dates.appendChild(e);
            }

            doc.appendChild(e_root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null) {
                writeDocument(doc, FILE_data_dates);
            }
        }
    }

    /**
     * Функция записи продавцов и количества проданных ими товаров в XML файл
     * @param sellers продавцы, которых нужно записать в файл
     */
    public void writeSellersToXML(List<Seller> sellers) {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder        db  = null;
        Document               doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db  = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element e_root   = doc.createElement("SellersInfo");
            e_root.setAttribute("lang", "en");
            Element e_sellers  = doc.createElement("Sellers");
            e_root.appendChild(e_sellers);

            for (Seller s : sellers){
                Element e = doc.createElement("Seller");
                // e.setTextContent(s.);
                e.setAttribute("name", s.getName());
                e.setAttribute("sur_name", s.getSurname());
                e.setAttribute("quantity_of_sold_product", s.getQuantityOfSoldProduct() + "");
                e_sellers.appendChild(e);
            }

            doc.appendChild(e_root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null) {
                writeDocument(doc, FILE_data_sellers);
            }
        }
    }

    /**
     * Процедура сохранения DOM в файл
     * http://java-online.ru/java-xml.xhtml
     */
    private void writeDocument(Document document, String path) throws TransformerFactoryConfigurationError {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);

        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
