package Hilo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JButton;

public class BarraDeTareas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraDeTareas frame = new BarraDeTareas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BarraDeTareas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,600,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEligeUnaAplicacin = new JLabel("Elige una aplicaci\u00F3n");
		lblEligeUnaAplicacin.setFont(new Font("Rubik", Font.PLAIN, 18));
		lblEligeUnaAplicacin.setBounds(12, 13, 225, 27);
		contentPane.add(lblEligeUnaAplicacin);
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon("F:\\DAM2\\PSP\\Tema1\\img\\Spotify.png"));
		btn1.setBounds(108, 90, 87, 74);
		contentPane.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ProcessBuilder uno = new ProcessBuilder("C:\\Users\\yunyang\\AppData\\Roaming\\Spotify\\Spotify.exe");
							uno.start();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon("F:\\DAM2\\PSP\\Tema1\\img\\chrome.png"));
		btn3.setBounds(315, 56, 134, 139);
		contentPane.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ProcessBuilder dos = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
					dos.start();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon("F:\\DAM2\\PSP\\Tema1\\img\\cmd.png"));
		btn4.setBounds(88, 246, 183, 111);
		contentPane.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					//ProcessBuilder tres = new ProcessBuilder("cmd.exe");
					//tres.start();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("F:\\DAM2\\PSP\\Tema1\\img\\libreofice.png"));
		btnNewButton.setBounds(376, 246, 97, 97);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ProcessBuilder cuatro = new ProcessBuilder("C:\\Program Files\\LibreOffice\\program\\soffice.exe");
					cuatro.start();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		
	}
}
