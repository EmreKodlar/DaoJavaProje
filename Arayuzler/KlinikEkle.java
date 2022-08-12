package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplements.ClinicDaoImplements;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KlinikEkle extends JFrame {

	private JPanel contentPane;
	private JTextField k_ad;
	
	ClinicDaoImplements cdi=new ClinicDaoImplements();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KlinikEkle frame = new KlinikEkle();
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
	public KlinikEkle() {
		setTitle("Klinik Ekleme Paneli");
	 
		setBounds(100, 100, 450, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		k_ad = new JTextField();
		k_ad.setBounds(52, 76, 312, 20);
		contentPane.add(k_ad);
		k_ad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Klinik Adı Giriniz:");
		lblNewLabel.setBounds(52, 51, 134, 14);
		contentPane.add(lblNewLabel);
		
		JButton k_ekle = new JButton("EKLE");
		k_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(k_ad.getText().length()<=0) {
					
					JOptionPane.showMessageDialog(null, "Boş Bırakmayınız!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				else {
					
					cdi.addClinic(k_ad.getText());
					
					JOptionPane.showMessageDialog(null, "Başarıyla Eklediniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
					k_ad.setText("");
					
				}
				 
				
				
			}
		});
		k_ekle.setBounds(52, 107, 124, 23);
		contentPane.add(k_ekle);
	}
}
