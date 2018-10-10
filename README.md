 Ejercicio 3
 =======
 1. Clases
 ------
 **Empleado**
 ```java
 public class Empleado {
	protected String nombre;
	
	public Empleado() {
		
	}
	public Empleado(String nombre) {
		this.nombre = nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String toString() {
		return "Empleado " + this.nombre;
	}
	
	
}

 ```
 **Operario**
 ```java
public class Operario extends Empleado{
	public Operario(String nombre) {
		super(nombre);
	}
	public String toString() {
		return super.toString() + " -> Operario ";
	}
}

 ```
 **Directivo**
 ```java
public class Directivo extends Empleado {
	
	public Directivo(String nombre) {
		super(nombre);
	}
	public String toString() {
		return super.toString() + " -> Directivo ";
	}
}

 ```
 **Oficial**
 ```java
 public class Oficial extends Operario{
	public Oficial(String nombre) {
		super(nombre);
	}
	public String toString() {
		return super.toString() + " -> Oficial ";
	}
}

 ```
 **Tecnico**
 ```java
 public class Tecnico extends Operario{
	public Tecnico(String nombre) {
		super(nombre);
	}
	public String toString() {
		return super.toString() + " -> Tecnico ";
	}
}
 ```
 2.Main y salida
 ------
 **Main**
 ```java
 public class ejerHerencia {

	public static void main(String[] args) {
		
		Empleado E1 = new Empleado("Rafa");
		Directivo D1 = new Directivo("Mario");
		Operario OP1 = new Operario("Alfonso");
		Oficial OF1 = new Oficial("Luis");
		Tecnico T1 = new Tecnico("Pablo");
		System.out.println(E1 + "\n" + D1 + "\n" + OP1 + "\n" + OF1 + "\n" + T1);
	}

}
 
 ```
 **Salida**
