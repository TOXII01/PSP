package Hilo;

public class UnoProcessBuilder {
	public static void main(String[] args) {
		try {
			ProcessBuilder uno = new ProcessBuilder("C:\\Users\\yunyang\\AppData\\Roaming\\Spotify\\Spotify.exe");
			uno.start();
		}catch(Exception e) {
			System.out.println("Excepcion" + e);
		}
	}
}
