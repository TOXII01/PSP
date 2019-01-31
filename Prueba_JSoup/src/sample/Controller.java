package sample;

import javafx.event.ActionEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Controller {
    public void searchTitle(ActionEvent actionEvent) throws IOException {
        System.out.println("Funciona");
        Document doc = Jsoup.connect("http://blog.elinsti.com").get();
        System.out.println(doc.title());
        Elements headLines = doc.select("h4.widgettitle");
        for(Element e : headLines) {
            System.out.println(e.text());
        }

    }
}
