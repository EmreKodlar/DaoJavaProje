package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DaoImplements.AdminDaoImplements;
import DaoImplements.UserDaoImplements;
import Siniflar.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calisanlar extends JFrame {

	private JPanel contentPane;
	
	static int c_id_al;
	
	//UserDaoImplements daoUserNesne= new UserDaoImplements(); bu aşağıdaki olarak değiştirildi
	AdminDaoImplements daoUserNesne= new AdminDaoImplements();
	public User userGet=new User();
	
	//tablo oluşturma
	private DefaultTableModel modelim = new DefaultTableModel();
	private Object[] kolonlar= {"ID","TC","Isim","Sifre","Tip"};
	private Object[] satirlar= new Object[5];
	 
	private JTable tabloUser2;
	private JButton silCalisan;
	private JLabel lblNewLabel;
	private JTextField tcNo;
	private JLabel lblIsimsoyisim;
	private JTextField isim;
	private JLabel lblNewLabel_2;
	private JTextField sifre;
	private JLabel lblNewLabel_3;
	private JTextField yer;
	private JButton pEkle;
	public JLabel kisi_getir;
	private JButton duzAc;
	private JTextField tipp;
	private JLabel lblNewLabel_1;
	//----------------------------------


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calisanlar frame = new Calisanlar();
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
	public Calisanlar() {
		setTitle("ÇALIŞANLAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 657, 296);
		contentPane.add(scrollPane);
		
		tabloUser2 = new JTable();
		tabloUser2.setBounds(105, 141, 212, 135);
		 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(tabloUser2);
		
		listeYenile();
		
		silCalisan = new JButton("SİL");
		silCalisan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				 
				 if(tabloUser2.getSelectedRow()<0) {
					 				
						JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
						 userGet=daoUserNesne.getAllUsers().get(tabloUser2.getSelectedRow());  // tablodan nesne alma işlemi...
							
							/*int row = tabloUser2.getSelectedRow();
							
							userGet = daoUserNesne.getAllUsers().get(tabloUser2.convertRowIndexToModel(tabloUser2.getSelectedRow()));*/
				 
				 daoUserNesne.deleteUser(userGet);
				 
				 JOptionPane.showMessageDialog(null,userGet.getName() + " isimli Kullanıcı Başarıyla Silindi!", "Kullanıcı Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenile();
					}
				
			}
		});
		silCalisan.setBounds(10, 363, 166, 23);
		contentPane.add(silCalisan);
		
		lblNewLabel = new JLabel("TC No:");
		lblNewLabel.setBounds(689, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		tcNo = new JTextField();
		tcNo.setBounds(689, 71, 186, 20);
		contentPane.add(tcNo);
		tcNo.setColumns(10);
		
		lblIsimsoyisim = new JLabel("İsim&Soyisim");
		lblIsimsoyisim.setBounds(689, 113, 142, 14);
		contentPane.add(lblIsimsoyisim);
		
		isim = new JTextField();
		isim.setBounds(689, 126, 186, 20);
		isim.setColumns(10);
		contentPane.add(isim);
		
		lblNewLabel_2 = new JLabel("Şifre:");
		lblNewLabel_2.setBounds(689, 168, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		sifre = new JTextField();
		sifre.setBounds(689, 186, 186, 20);
		sifre.setColumns(10);
		contentPane.add(sifre);
		
		lblNewLabel_3 = new JLabel("Çalıştığı yer Kodu:");
		lblNewLabel_3.setBounds(689, 234, 142, 14);
		contentPane.add(lblNewLabel_3);
		
		yer = new JTextField();
		yer.setBounds(689, 247, 186, 20);
		yer.setColumns(10);
		contentPane.add(yer);
		
		pEkle = new JButton("PERSONEL EKLE");
		pEkle.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				 
				if(tcNo.getText().length()==0 || isim.getText().length()==0 || sifre.getText().length()==0 || yer.getText().length()==0 || tipp.getText().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Boş Alan Bırakmayınız!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					daoUserNesne.addUser(tcNo.getText(), isim.getText(), sifre.getText(), Integer.parseInt(yer.getText()),tipp.getText());
					listeYenile();
					JOptionPane.showMessageDialog(null, "Başarıyla Eklendi", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					tcNo.setText("");
					isim.setText("");
					sifre.setText("");
					yer.setText("");
					
				}
				
			}
		});
		pEkle.setBounds(689, 329, 186, 23);
		contentPane.add(pEkle);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 902, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Çalışan İşlemleri");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu = new JMenu("Klinik İşlemleri");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnıtmNewMenuItem = new JMenuItem("Klinik Ekle");
		mnıtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KlinikEkle klin=new KlinikEkle();
				
				klin.setVisible(true);
 
			}
		});
		mnNewMenu.add(mnıtmNewMenuItem);
		
		 
		
		JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Klinik Düzenle");
		mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Klinikler kli=new Klinikler();
				
				kli.setVisible(true);
				
				dispose();
				
			}
		});
		mnNewMenu.add(mnıtmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Doktor İşlemleri");
		menuBar.add(mnNewMenu_1);
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("\"Doktor Klinik Ataması");
		mnNewMenu_1.add(mnıtmNewMenuItem_2);
		mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DoktorAtama doa=new DoktorAtama();
				
				doa.setVisible(true);
				
			}
		});
		
		
		
		
		kisi_getir = new JLabel("New label");
		kisi_getir.setBounds(10, 33, 657, 14);
		contentPane.add(kisi_getir);
		
		duzAc = new JButton("Düzenle");
		duzAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(tabloUser2.getSelectedRow()<0) {
					
					JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				else {
					
					userGet=daoUserNesne.getAllUsers().get(tabloUser2.getSelectedRow());  // tablodan nesne alma işlemi...
					
					CalisanDuz cdu=new CalisanDuz();
					
					cdu.tcc.setText(userGet.getTcno());
					cdu.isimm.setText(userGet.getName());
					cdu.sifree.setText(userGet.getPassword());
					cdu.typee.setText(userGet.getType());
					cdu.id_getir.setText(String.valueOf(userGet.getId()));
					cdu.bolumm.setText(String.valueOf(userGet.getBolum()));
					
					cdu.setVisible(true);
					
					
			 }
				
				
			}
		});
		duzAc.setBounds(195, 363, 127, 23);
		contentPane.add(duzAc);
		
		tipp = new JTextField();
		tipp.setColumns(10);
		tipp.setBounds(689, 298, 186, 20);
		contentPane.add(tipp);
		
		lblNewLabel_1 = new JLabel("Tip:");
		lblNewLabel_1.setBounds(689, 285, 142, 14);
		contentPane.add(lblNewLabel_1);
		
	}
	
	public void listeYenile() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<daoUserNesne.getAllUsers().size(); i++) {
			
			satirlar[0]=daoUserNesne.getAllUsers().get(i).getId();
			satirlar[1]=daoUserNesne.getAllUsers().get(i).getTcno();
			satirlar[2]=daoUserNesne.getAllUsers().get(i).getName();
			satirlar[3]=daoUserNesne.getAllUsers().get(i).getPassword();
			satirlar[4]=daoUserNesne.getAllUsers().get(i).getType();
			modelim.addRow(satirlar);
			}
		tabloUser2.setModel(modelim);
	}
	
 
}
