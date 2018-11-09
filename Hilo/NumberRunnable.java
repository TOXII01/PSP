package Hilo;

public class NumberRunnable implements Runnable{
	int num;
	
	public NumberRunnable(int num) {
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
