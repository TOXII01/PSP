import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ScrapeLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("https://elpais.com/").get();
		String title = doc.title();
		System.out.println("Titulo : " + title);
		
		Elements links = doc.select("a[href]");
		for(Element e : links) {
			System.out.println("Link : " + e.attr("href"));
			System.out.println("Texto : " + e.text());
		}
	}

}
