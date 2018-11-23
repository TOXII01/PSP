package ejerBuscaSO;
/* 
 * Todas las rutas están en local
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean validar = false;
		do {
			System.out.println("Elige una opcion : ");
			System.out.println("1. Abrir aplicación de PDF");
			System.out.println("2. Abrir hija de Calculo");
			System.out.println("3. Ver en consola la version de Java");
			System.out.println("4. SALIR");
			int op = sc.nextInt();
			sc.nextLine();
			switch(op) {
			case 1:
				try {
					ProcessBuilder abrirPDF = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
					abrirPDF.start();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				try {
					ProcessBuilder abrirHojaCalculo = new ProcessBuilder("C:\\Program Files\\LibreOffice\\program\\scalc.exe");
					abrirHojaCalculo.start();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				try {
					/* Realiza 2 acciones : 
					 *  1. Abre la consola 
					 *  2. Ejecuta el comando "java -version" y muestra la salida en Java
					 * No puedo abrir la consola y ejecutar el comando en ella
					 */
					String[] cmd = {"cmd.exe","/k","start"};
					Process versionJava = new ProcessBuilder(cmd).start();
					String[] salidaVersion = {"cmd.exe","/k","java -version"};
					Process salidaJava = new ProcessBuilder(salidaVersion).start();
										
					InputStream is = salidaJava.getErrorStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					
					String linea;
					while((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
					versionJava.waitFor();
					salidaJava.waitFor();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 4: 
				validar = true;
				break;
			default:
				System.out.println("No se reconoce la opción");
				break;
		}
	}while(!validar);
		
	}

}
