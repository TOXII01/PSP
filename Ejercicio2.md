Ejercicio 2
=======
Introducir DNI, comprobar letra y devolver
------
```java
  package ejerQuiniela;
import java.util.*;
public class ejerDNI {
	public static void compruebaNIF(String nif) {
		String[] letrasNIF = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		String nie = nif;
		if(nif.startsWith("x")) {
			nie = 0 + nif.substring(1,nif.length());
		}
		else if(nif.startsWith("y")) {
			nie = 1 + nif.substring(1,nif.length());
		}
		else if(nif.startsWith("z")) {
			nie = 2 + nif.substring(1,nif.length());
		} 
		int numero = Integer.parseInt(nie.substring(0, nie.length() - 1));
		String letra = nie.substring(nie.length() - 1, nie.length()).toUpperCase();
		int pos = numero % 23;
		
		if(letrasNIF[pos].equalsIgnoreCase(letra)) {
			System.out.println("El NIF " + nif + " es correcto");
		} else {
			System.out.println("El NIF " + nif + " es incorrecto.\nLa letra tendría que ser " + letrasNIF[pos]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
		System.out.print("Introduce el NIF : ");
		String nif = sc.next();
		sc.nextLine();
		if(nif.equals("0")) {
			System.out.println("FIN");
			break;
		}
		compruebaNIF(nif);
		}
		while(true);
	}
}

```
