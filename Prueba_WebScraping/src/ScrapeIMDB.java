

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeIMDB {
	public static void doScrapping(String url) {
		Document web = null;
		try {
			web = Jsoup.connect(url).get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Elements tbody = web.getElementsByTag("tbody");
		Elements filas = tbody.get(0).select("tr");
		for(Element e : filas) {
			Elements columnas = e.getElementsByTag("td");
			for(int i = 1; i < 3; i++) {
				System.out.print(columnas.get(i).text() + "  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		String url = "https://www.imdb.com/chart/top";
		doScrapping(url);
	}
}
