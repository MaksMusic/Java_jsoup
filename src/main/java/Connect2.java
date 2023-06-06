import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Connect2 {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.gismeteo.ru/weather-london-744/").get();
        }catch (Exception e){
            e.printStackTrace();
        }

        if (doc!= null){
            var title = doc.selectFirst("title").text();
            System.out.println("title " + title);

            System.out.println();
            var elements = doc.select("a");
            for (Element element : elements) {
                System.out.println(element.text());
            }

            //ссылки
            System.out.println();
            for (Element element : elements) {
                System.out.println(element.attr("href"));
            }


            //по классу
            System.out.println("class");
            var elementsClass = doc.select(".unit_temperature_c");
            for (Element element : elementsClass) {
                System.out.println(element.text());
            }

            System.out.println();
            var elementsClass2 = doc.select(".page-title");
            for (Element element : elementsClass2) {
                System.out.println(element.text());
            }

            //или если в классе 1 element
            System.out.println(doc.selectFirst(".page-title").text());

        }

        System.out.println();
    }
}
