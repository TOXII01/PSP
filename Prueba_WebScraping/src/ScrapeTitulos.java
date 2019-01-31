import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.SynchronousQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeTitulos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			String fichero = "C:\\Users\\yunyang\\Desktop\\noticias.txt";
			FileInputStream fis = new FileInputStream(fichero);
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			String linea;
			File arch = new File("C:\\Users\\yunyang\\Desktop\\noticias");
			arch.mkdir();
			while((linea = br.readLine())!= null) {
				System.out.println(linea);
				try {
					String lineas = linea.substring(6);
					File arch2 = new File("C:\\Users\\yunyang\\Desktop\\noticias\\" + lineas + ".txt");
					arch2.createNewFile();
					FileWriter archivo = new FileWriter(arch2,true);
					PrintWriter pw = new PrintWriter(archivo);
					Document doc = Jsoup.connect(linea).get();
					
					String title = doc.title();
					System.out.println("Titulo : " + title);
					
					Elements h2 = doc.select("h2>a");
					Elements h3 = doc.select("h3>a");
					
					for(Element e : h2) {
						System.out.println(e.attr("headline"));
						pw.println(e.attr("headline"));
					}
					for(Element e : h3) {
						System.out.println(e.attr("title"));
						pw.println(e.attr("title"));
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

