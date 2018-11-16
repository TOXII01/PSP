package Hilo;

import java.io.IOException;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import java.io.*;

public class DosProcessBuilder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/* Muestra los directorios de consola*/
		//final String comandos[] = {"cmd.exe","/c","dir"};
		/*Mostrar procesos*/
		final String comandos[] = {"cmd.exe","/c","TASKLIST/v"};
		try {
			Process proceso = new ProcessBuilder(comandos).start();
			
			InputStream is = proceso.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			/* Indica cuando ha terminado la tarea del READER */
			int exitValue = proceso.waitFor();
			System.out.println("\nCodigo de Salida : " + exitValue);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion" + e);
		}
		
	}

}
