package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DaoImplements.AdminDaoImplements;
import DaoImplements.UserDaoImplements;
import Siniflar.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalisanDuz extends JFrame {

	private JPanel contentPane;
	  JTextField tcc;
	  JTextField isimm;
	  JTextField sifree;
	  JTextField bolumm;
	  JTextField id_getir;
	
	AdminDaoImplements daoUserNesne= new AdminDaoImplements();
	User userGet=new User();
	Calisanlar cal=new Calisanlar();
	private JLabel lblId;
	 JTextField typee;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalisanDuz frame = new CalisanDuz();
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
	public CalisanDuz() {
		setTitle("Çalışan Düzenle");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC");
		lblNewLabel.setBounds(46, 73, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIsim = new JLabel("İsim");
		lblIsim.setBounds(46, 111, 46, 14);
		contentPane.add(lblIsim);
		
		JLabel lblifre = new JLabel("Şifre");
		lblifre.setBounds(46, 152, 46, 14);
		contentPane.add(lblifre);
		
		JLabel lblYer = new JLabel("Bölüm No");
		lblYer.setBounds(46, 190, 56, 14);
		contentPane.add(lblYer);
		
		tcc = new JTextField();
		tcc.setBounds(129, 69, 231, 20);
		contentPane.add(tcc);
		tcc.setColumns(10);
		
		
		
		isimm = new JTextField();
		isimm.setColumns(10);
		isimm.setBounds(129, 107, 231, 20);
		contentPane.add(isimm);
		
		sifree = new JTextField();
		sifree.setColumns(10);
		sifree.setBounds(129, 149, 231, 20);
		contentPane.add(sifree);
		
		bolumm = new JTextField();
		bolumm.setColumns(10);
		bolumm.setBounds(129, 187, 231, 20);
		contentPane.add(bolumm);
		
	 
		
		JButton cDuz = new JButton("Düzenle");
		cDuz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(tcc.getText().length()==0 || isimm.getText().length()==0 || sifree.getText().length()==0 || bolumm.getText().length()==0 ) {
					
					JOptionPane.showMessageDialog(null, "Boş Alan Bırakmayınız!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
	
					userGet=new User(Integer.parseInt(id_getir.getText()),tcc.getText(),isimm.getText(),sifree.getText(),typee.getText(),Integer.parseInt(bolumm.getText()));
	
					daoUserNesne.updateUser(userGet);
					
					JOptionPane.showMessageDialog(null, "Başarıyla Düzenlendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					tcc.setText("");
					isimm.setText("");
					sifree.setText("");
					bolumm.setText("");
					cal.listeYenile();
					 
					
				}
			}
		});
		cDuz.setBounds(129, 260, 231, 23);
		contentPane.add(cDuz);
		
		id_getir = new JTextField();
		id_getir.setEditable(false);
		id_getir.setEnabled(false);
		id_getir.setBounds(129, 30, 231, 20);
		contentPane.add(id_getir);
		id_getir.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(46, 33, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTip = new JLabel("Tip");
		lblTip.setBounds(46, 232, 56, 14);
		contentPane.add(lblTip);
		
		typee = new JTextField();
		typee.setColumns(10);
		typee.setBounds(129, 229, 231, 20);
		contentPane.add(typee);
	}
}
