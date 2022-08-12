package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplements.UserDaoImplements;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KullaniciGirisi extends JFrame {

	private JPanel contentPane;
	private JTextField tc;
	private JPasswordField sif;
	
	private boolean sonuc=false;
	
	private UserDaoImplements daoUserNesne= new UserDaoImplements();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciGirisi frame = new KullaniciGirisi();
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
	public KullaniciGirisi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Giriş Paneli");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 51, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTcNo = new JLabel("TC No:");
		lblTcNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTcNo.setBounds(41, 94, 75, 14);
		contentPane.add(lblTcNo);
		
		JLabel lblifre = new JLabel("Şifre:");
		lblifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifre.setBounds(41, 130, 75, 14);
		contentPane.add(lblifre);
		
		tc = new JTextField();
		tc.setBounds(126, 91, 156, 20);
		contentPane.add(tc);
		tc.setColumns(10);
		
		sif = new JPasswordField();
		sif.setBounds(126, 127, 156, 20);
		contentPane.add(sif);
		
		JButton giris = new JButton("GİRİŞ");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
for(int i=0; i<daoUserNesne.getAllUsers().size(); i++) {
					
					if(tc.getText().equals(daoUserNesne.getAllUsers().get(i).getTcno())
							&&
					   sif.getText().equals(daoUserNesne.getAllUsers().get(i).getPassword())) 
					{
						if(daoUserNesne.getAllUsers().get(i).getType().equals("Admin")) {
						 
						sonuc=true;
						
						Calisanlar cd=new Calisanlar();
 	
						//cd.c_id_al=daoUserNesne.getAllUsers().get(i).getId();
						
						cd.kisi_getir.setText("Giriş Yapan Kullanıcı: " + daoUserNesne.getUser(daoUserNesne.getAllUsers().get(i).getId()).getName());
  
						cd.setVisible(true);
						
						dispose();
						}
						
						 
					}
				 
			}

			if(sonuc==false) {
	
			JOptionPane.showMessageDialog(null, "Tc ya da Şifre Hatalı", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
							}
			}
		});
		giris.setBounds(157, 174, 89, 23);
		contentPane.add(giris);
		
		
		
	}
}
