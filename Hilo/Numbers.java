package Hilo;

public class Numbers extends Thread implements Runnable{
	public static void main(String[] args) {
		/*
		 * En nuestro mai colocamos los diferentes hilos, 
		 * con diferentos números y los inicializamos.
		 */
		NumberThread n1,n2,n3,n4,n5,n6;
		n1 = new NumberThread(1); 
		n1.start();
		n2 = new NumberThread(2); 
		n2.start();
		n3 = new NumberThread(3); 
		n3.start();
		n4 = new NumberThread(4);
		n4.start();
		n5 = new NumberThread(5);
		n5.start();
		n6 = new NumberThread(6); 
		n6.start();
		
		/*
		 * Con la interface Runnable, necesitamos 
		 * declarar la clase hilo
		 * y depués el Runnable 
		 */
		Thread r1,r2,r3,r4,r5,r6;
		r1 = new Thread(new NumberRunnable(71)); 
		r1.start();
		r2 = new Thread(new NumberRunnable(72)); 
		r2.start();
		r3 = new Thread(new NumberRunnable(73));
		r3.start();
		r4 = new Thread(new NumberRunnable(74)); 
		r4.start();
		r5 = new Thread(new NumberRunnable(75)); 
		r5.start();
		r6 = new Thread(new NumberRunnable(76)); 
		r6.start();
		
		
	}
}
