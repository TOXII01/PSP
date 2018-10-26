package ejerAeropuertos;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
public class MainAeropuertos {
	public static void guardaAeropuertos() throws IOException {
	/* Primera parte,
	 * Recoger la URL, y hacer un lector.
	 * Crear un archivo donde almacenarlo y un writer.
	 * Leer el archivo e ir guardando en el fichero.
	 */
	
	/*
	 * Vector de Aeropuertos
	 * Coger la URL
	 * Crear el reader, cogemos los datos de la URL y los iremos escribiendo línea a línea
	 */
	 
	URL url = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
	URLConnection  con = url.openConnection();
	//Leer contenido
	BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	String line;	
	//Escribir contenido
	File f = new File("aeropuertos.txt");
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	try {
		//Escribir linea a linea
		while((line = in.readLine()) != null) {
			bw.write(line);
			bw.newLine();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	//Cerrar el reader y el writer
	in.close();
	bw.close();
	
	}
	/*
	 * Cogemos el fichero que hemos creado desde la URL y lo que hará el método es devolver un ArrayList de aeropuertos.
	 * Hacemos un Reader y volvemos a leer, pero en este caso el documento .txt,
	 * Lo guardamos y devolvemos
	 */
	public static List<String> guardaVectorAeropuertos() throws IOException {
		List<String> aeropuertos = new ArrayList<String>();
		FileReader fr = new FileReader("aeropuertos.txt");
		BufferedReader in = new BufferedReader(fr);
		String linea;
		//Guardamos linea a linea del .txt en el ArrayList
		while((linea = in.readLine()) != null) {
			aeropuertos.add(linea);
		}
		return aeropuertos;
		//System.out.println(aeropuertos.get(0));
	}

	public static void main(String[] args) throws IOException {
		
		//Primero guardamos los aeropuertos en un fichero.
		guardaAeropuertos();
		//Despues los leemos y guardamos en una lista.
		guardaVectorAeropuertos();
		
		
	}
}
