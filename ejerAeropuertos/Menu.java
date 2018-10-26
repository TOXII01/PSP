package ejerAeropuertos;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Menu {
	private static ArrayList<String> lista;
	private static List<String> aeropuertos = new ArrayList<String>();
	private JFrame frame;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAeropuertos.guardaAeropuertos();
					lista = (ArrayList<String>)MainAeropuertos.guardaVectorAeropuertos();
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Menu() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDatos = new JTextField();
		txtDatos.setBounds(39, 59, 116, 22);
		frame.getContentPane().add(txtDatos);
		txtDatos.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(167, 59, 253, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnURL = new JButton("Ver en GoogleMaps");
		btnURL.setBounds(227, 100, 151, 25);
		frame.getContentPane().add(btnURL);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(49, 95, 93, 35);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dato = txtDatos.getText().toString();
				for (int i = 0; i < lista.size(); i++) {
					if(lista.get(i).contains(dato)) {
						aeropuertos.add(lista.get(i));
					}
				}
				if(aeropuertos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado");
				} else {
					comboBox.removeAllItems();		
					for (int i = 0; i < aeropuertos.size(); i++) {
						if(aeropuertos.get(i) != null) {
							comboBox.addItem(aeropuertos.get(i));
						}
					}
					aeropuertos.clear(); 	
					System.out.println(comboBox.getSelectedItem().toString());
					}
				}

			});
		btnURL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String[] lugar = ((String) comboBox.getSelectedItem()).split(",");
				String latitud = lugar[6];
				String longitud = lugar[7];
				
				String URLBusqueda = "https://www.google.com/maps/search/?api=1&query=";
				String URLCompleto = URLBusqueda + latitud + "," + longitud;
					if(java.awt.Desktop.isDesktopSupported()) {
						java.awt.Desktop dk  = java.awt.Desktop.getDesktop();
							if(dk.isSupported(java.awt.Desktop.Action.BROWSE)) {
								try {
									java.net.URI uri = new java.net.URI(URLCompleto);
									dk.browse(uri);		
									}catch(Exception ex) {
										JOptionPane.showMessageDialog(null,"No se ha podido acceder a la URL");
								}
							}
						}	
					}

				});
		
		JLabel lblDesc = new JLabel("Introduce el aeropuerto");
		lblDesc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDesc.setBounds(25, 13, 214, 16);
		frame.getContentPane().add(lblDesc);
		
		
	}
}
