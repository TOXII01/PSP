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
	/* 
	 * Creamos 2 Listas :
	 * La primera corresponde con la lista de aeropuertos que hemos sacado de la URL 
	 * La segunda corresponde con la lista de aeropuertos que se generarán con la busqueda que el usuario hará
	 */
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
					/*
					 * Llamamos al método de la clase Main para que coja la URL,
					 * Y lo pase a un archivo .txt, este paso solo se hará una vez
					 */
					MainAeropuertos.guardaAeropuertos();
					/*
					 * Asignamos los aeropuertos del .txt a una lista de Strings
					 * guardamos todos los datos de los aeropuertos, los 14 en forma de String
					 */
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
		/*
		 * En el frame autogenerado, hacemos un absolutLayout,
		 * Creamos un Label, un TextField, un ComboBox y 2 botones
		 */
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
		/*
		 * Cuando el botón se pulse recogemos el dato del TextField
		 * Hacemos un bucle con la lista de aeropuertos 
		 * Si lo contiene lo guardamos en el ComboBox para mostrarlo
		 */
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Cogemos el dato del TextField
				String dato = txtDatos.getText().toString();
				//Hacemos la busqueda respecto a la lista de aeropuertos
				for (int i = 0; i < lista.size(); i++) {
					if(lista.get(i).contains(dato)) {
						aeropuertos.add(lista.get(i));
					}
				}
				//Si no ha encontrado ninguno muestra mensaje de error
				if(aeropuertos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado");
				} else {
					/*
					 * Si ha encontrado aeropuertos,
					 * primero se asegura de eliminar los datos del comboBox 
					 * en caso de que se busquen varios aeropuertos 
					 * tendremos que borrar los resultados anteriores
					 */
					comboBox.removeAllItems();		
					for (int i = 0; i < aeropuertos.size(); i++) {
						if(aeropuertos.get(i) != null) {
							comboBox.addItem(aeropuertos.get(i));
						}
					}
					/* Tambien tenemos que borrar la lista de aeropuertos 
					 * Que correspondan con el dato introducido en el TextField
					 * Para que no se añadan los valores de búsquedas anteriores
					 */
					aeropuertos.clear(); 	
					//System.out.println(comboBox.getSelectedItem().toString());
					}
				}

			});
		
		 // Creamos el listener del Botón para acceder a GoogleMaps
		btnURL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/*
				* Cogemos la línea completa del aeropuerto 
				* Cogemos los datos del array 6 y 7, corresponden a la altitud y la longitud
				*/
				String[] lugar = ((String) comboBox.getSelectedItem()).split(",");
				String latitud = lugar[6];
				String longitud = lugar[7];
				//Introducimos los la altitud y la longitud en la query e inicia el buscador
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
