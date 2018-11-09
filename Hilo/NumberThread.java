package Hilo;
/*
 * Declaramos el nombre de la clase Hilo y extendemos la clase Thread
 */
public class NumberThread  extends Thread{
	int num;
	
	public NumberThread(int num) {
		this.num = num;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * Clase del método Thread para implementar nuestro codigo, tiene que ser Run,
	 * Cuando llamamos al Start en le Main inicia el hilo
	 */
	public void run() {
		for(int k = 0; k < 10; k++) {
			System.out.println(num);
		}
	}
}
