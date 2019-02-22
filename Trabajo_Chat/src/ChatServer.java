import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
public class ChatServer {

	public static void main(String[] args) {

		MarcoServidor mimarco= new MarcoServidor();	
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
	class MarcoServidor extends JFrame implements Runnable{
		
		public MarcoServidor(){
			
			setBounds(1200,300,280,350);					
			JPanel milamina= new JPanel();
			milamina.setLayout(new BorderLayout());
			areatexto=new JTextArea();	
			milamina.add(areatexto,BorderLayout.CENTER);	
			add(milamina);	
			setVisible(true);
			Thread escucha = new Thread(this);
			escucha.start();
			
			}
		 
		private	JTextArea areatexto;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println("Estoy escuchando");
			try {
				ServerSocket servidor = new ServerSocket(9999);
				String ip,nick,envio;
				Envio paquete_recibido;
				/* Enviar muchos mensajes */  
				while(true) {
				/* Aceptar las conexiones del exterior */
				Socket miSocket = servidor.accept();
				ObjectInputStream datos = new ObjectInputStream(miSocket.getInputStream());
				paquete_recibido = (Envio) datos.readObject();
				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				envio = paquete_recibido.getMessage();
				areatexto.append("\n" + nick + ": " + envio + " para : " + ip);
				Socket enviaInfo = new Socket(ip,9090);
				ObjectOutputStream datos_reenvio = new ObjectOutputStream(enviaInfo.getOutputStream());
				datos_reenvio.writeObject(paquete_recibido);
				enviaInfo.close();
				miSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



