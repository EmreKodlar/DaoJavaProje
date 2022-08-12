package Arayuzler;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import DaoImplements.AdminDaoImplements;
import DaoImplements.ClinicDaoImplements;
import Siniflar.User;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoktorAtama extends JFrame {

	private JPanel contentPane;
	//tablo oluşturma
	private DefaultTableModel modelim = new DefaultTableModel();
	private Object[] kolonlar= {"ID","TC","Isim"};
	private Object[] satirlar= new Object[3];
	private JTable tabloDoktor;
	
	AdminDaoImplements daoUserNesne= new AdminDaoImplements();
	public User userGet=new User();
	
	ClinicDaoImplements  cdim= new ClinicDaoImplements();
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorAtama frame = new DoktorAtama();
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
	public DoktorAtama() {
		setTitle("Doktor Atama");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 32, 371, 277);
		contentPane.add(scrollPane2);
		
		tabloDoktor = new JTable();
		tabloDoktor.setBounds(105, 141, 212, 135);
		 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane2.setViewportView(tabloDoktor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(412, 32, 199, 22);
		contentPane.add(comboBox);
		
	for(int i=0; i<cdim.getAllClinic().size() ;i++ ) {
			
			comboBox.addItem(cdim.getAllClinic().get(i).getIsim());
		 
			
		}
		
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(420, 99, 191, 153);
		contentPane.add(calendar);
		
		JButton btnNewButton = new JButton("ATAMAYI YAP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(tabloDoktor.getSelectedRow()<0) {
		 				
						JOptionPane.showMessageDialog(null, "Önce Doktor Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
				
				  int clinicID = cdim.getAllClinic().get(comboBox.getSelectedIndex()).getId();
				  String tarih=calendar.getDate().toString();
				  
				  
					// userGet=daoUserNesne.getAllUsers().get(tabloDoktor.getSelectedRow());  // tablodan nesne alma işlemi...
					 
					 int doktorId=Integer.parseInt(tabloDoktor.getValueAt(tabloDoktor.getSelectedRow(), 0).toString());
					 String doktornamee=tabloDoktor.getValueAt(tabloDoktor.getSelectedRow(), 2).toString();
				  
					 daoUserNesne.updateDoktor( tarih,  clinicID,  doktorId );
					 JOptionPane.showMessageDialog(null, " Atama Bilgileri:\n" + tarih +"\n"+ 
					 
							 cdim.getAllClinic().get(comboBox.getSelectedIndex()).getIsim()  +"\n"+ 
							 
								doktornamee,
							 
							 "Atama Başarıyla Yapıldı", JOptionPane.INFORMATION_MESSAGE);
						
					}
				
			}
		});
		btnNewButton.setBounds(420, 286, 191, 23);
		contentPane.add(btnNewButton);
		
	
        JLabel dogumTarJLabel = new JLabel("Doğum tarihi",JLabel.CENTER);
	      JDateChooser randevuTarihiChooser = new JDateChooser();
		
		
		listeYenileDoktor();
	}
	
	
public void listeYenileDoktor() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<daoUserNesne.getAllDoctors().size(); i++) {
			
			satirlar[0]=daoUserNesne.getAllDoctors().get(i).getId();
			satirlar[1]=daoUserNesne.getAllDoctors().get(i).getTcno();
			satirlar[2]=daoUserNesne.getAllDoctors().get(i).getName();
			 
			modelim.addRow(satirlar);
			}
	tabloDoktor.setModel(modelim);
	}
}
