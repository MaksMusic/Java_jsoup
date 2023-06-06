import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Connect {
    public static void main(String[] args) {
        try {
           var doc =  Jsoup.connect("http://www.planet-online.ru/").get();
           var title = doc.selectFirst("title").text();

            //заголовки
           var elements = doc.select("h3");
            for (Element element : elements) {
                System.out.println(element.text());
            }

            System.out.println();
            //заголовки всех ссылок
            var elements2 = doc.select("a");
            for (Element element2 : elements2) {
                System.out.println(element2.text());
            }

            //сами ссылки
            var elements3 = doc.select("a");
            for (Element element3 : elements3) {
                System.out.println(element3.attr("href"));
            }


            //получить текст по id
            System.out.println();
            var elements4 = doc.select("#content");
            for (Element element : elements4) {
                System.out.println(element.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
