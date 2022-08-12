package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DaoImplements.AdminDaoImplements;
import DaoImplements.ClinicDaoImplements;
import DaoImplements.UserDaoImplements;
import Siniflar.Clinic;
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

public class Klinikler extends JFrame {

	private JPanel contentPane;
	
	static int c_id_al;
	
 
	ClinicDaoImplements daoUserNesne= new ClinicDaoImplements();
	Clinic clinicGet=new Clinic();
	
	//tablo oluşturma
	private DefaultTableModel modelim = new DefaultTableModel();
	private Object[] kolonlar= {"ID","Isim"};
	private Object[] satirlar= new Object[2];
	 
	private JTable tabloUser2;
	private JButton silCalisan;
	public JLabel kisi_getir;
	private JButton duzAc;
	//----------------------------------


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Klinikler frame = new Klinikler();
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
	public Klinikler() {
		setTitle("KLİNİKLER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 657, 318);
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
						 clinicGet=daoUserNesne.getAllClinic().get(tabloUser2.getSelectedRow());  // tablodan nesne alma işlemi...
							
							/*int row = tabloUser2.getSelectedRow();
							
							userGet = daoUserNesne.getAllUsers().get(tabloUser2.convertRowIndexToModel(tabloUser2.getSelectedRow()));*/
				 
				 daoUserNesne.deleteClinic(clinicGet);
				 
				 JOptionPane.showMessageDialog(null,clinicGet.getIsim() + " isimli Klinik Başarıyla Silindi!", "Klinik Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenile();
					}
				
			}
		});
		silCalisan.setBounds(684, 56, 166, 23);
		contentPane.add(silCalisan);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 902, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Çalışan İşlemleri");
		menuBar.add(mnNewMenu_2);
		JMenuItem mnıtmNewMenuItem_3 = new JMenuItem("Çalışan Ekle Çıkar");
		mnNewMenu_2.add(mnıtmNewMenuItem_3);
		mnıtmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Calisanlar cc= new Calisanlar();
				
				cc.setVisible(true);
				
				dispose();
				
 
			}
		});
		
		
 
		
		
		
		
		
		
		
		
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
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Doktor Klinik Ataması");
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
					
					clinicGet=daoUserNesne.getAllClinic().get(tabloUser2.getSelectedRow());  // tablodan nesne alma işlemi...
					
					KlinikDuz cdu=new KlinikDuz();
					
					cdu.cisim.setText(clinicGet.getIsim());
				
					cdu.idgetir.setText(String.valueOf(clinicGet.getId()));
				 
					
					cdu.setVisible(true);
					
					
			 }
				
				
			}
		});
		duzAc.setBounds(684, 103, 166, 23);
		contentPane.add(duzAc);
		
	}
	
	private void listeYenile() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<daoUserNesne.getAllClinic().size(); i++) {
			
			satirlar[0]=daoUserNesne.getAllClinic().get(i).getId();
			satirlar[1]=daoUserNesne.getAllClinic().get(i).getIsim();
			 
			modelim.addRow(satirlar);
			}
		tabloUser2.setModel(modelim);
	}
	
 
}
