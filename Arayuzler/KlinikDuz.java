package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplements.ClinicDaoImplements;
import Siniflar.Clinic;
import Siniflar.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KlinikDuz extends JFrame {

	private JPanel contentPane;
	public JTextField cisim;
	public JTextField idgetir;
	
	Clinic clinicGet;
	
	ClinicDaoImplements clinicdao=new ClinicDaoImplements();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KlinikDuz frame = new KlinikDuz();
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
	public KlinikDuz() {
		setTitle("Klinik Düzenle");
		 
		setBounds(100, 100, 409, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cisim = new JTextField();
		cisim.setBounds(33, 105, 324, 20);
		contentPane.add(cisim);
		cisim.setColumns(10);
		
		JButton btnNewButton = new JButton("Düzenle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cisim.getText().length()==0 ) {
					
					JOptionPane.showMessageDialog(null, "Boş Alan Bırakmayınız!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
	
					clinicGet=new Clinic(Integer.parseInt(idgetir.getText()),cisim.getText());
	
					clinicdao.updateClinic(clinicGet);
					
					JOptionPane.showMessageDialog(null, "Başarıyla Düzenlendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					 
				 
					 
					
				}
				
				
			}
		});
		btnNewButton.setBounds(33, 147, 113, 23);
		contentPane.add(btnNewButton);
		
		idgetir = new JTextField();
		idgetir.setEnabled(false);
		idgetir.setEditable(false);
		idgetir.setBounds(33, 63, 86, 20);
		contentPane.add(idgetir);
		idgetir.setColumns(10);
	}

}
