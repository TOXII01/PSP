import javax.swing.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
 public class ChatCliente {

	public static void main(String[] args) {
		MarcoCliente mimarco=new MarcoCliente();		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
 }
	class MarcoCliente extends JFrame{
		
		public MarcoCliente(){
			
			setBounds(600,300,280,350);				
			LaminaMarcoCliente milamina=new LaminaMarcoCliente();
			add(milamina);
			setVisible(true);
			}	
		
	}

	class LaminaMarcoCliente extends JPanel implements Runnable {
		
		public LaminaMarcoCliente(){
			nick = new JTextField(5);
			add(nick);			
			JLabel texto=new JLabel(" CHAT ");
			add(texto);
			ip = new JTextField(8);
			add(ip);
			areatexto  = new JTextArea(12,20);
			add(areatexto);			
			campo1=new JTextField(20);
			add(campo1);		
			miboton=new JButton("Enviar");
			EnviaTexto miEvento = new EnviaTexto();
			miboton.addActionListener(miEvento);
			add(miboton);	
			Thread hilo = new Thread(this);
			hilo.start();
			
		}
		private class EnviaTexto implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				areatexto.append("\n" + nick.getText() + ": " +  campo1.getText());
				try {
					Socket miSocket = new Socket("192.168.20.58",9999);
					Envio envio = new Envio();
					envio.setNick(nick.getText());
					envio.setIp(ip.getText());
					envio.setMessage(campo1.getText()); 
					ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());
					paquete_datos.writeObject(envio);
					miSocket.close();
							 		
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				System.out.println("No se ha conectado al Server" + e.getMessage());
				}
			}
			
			
		}
		private JTextField campo1,nick,ip;
		private JButton miboton;
		private JTextArea areatexto;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				ServerSocket server_cliente = new ServerSocket(9090);
				Socket cliente;
				Envio paqueteRecibido;
				while(true) {
					cliente = server_cliente.accept();
					ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
					paqueteRecibido = (Envio) flujoentrada.readObject();
					areatexto.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMessage());
					
				}
				
			}catch(Exception e) {
			System.out.println(e.getMessage());
			}
		}
		
	}
class Envio implements Serializable { 
	private String ip;
	private String nick;
	private String message;
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

