package org.esprit.javaee.project.client;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.esprit.javaee.project.services.TranslatorServiceRemote;




public class DictionnaryApp extends JFrame{
	
	private String jndiName = "/project-ejb/TranslatorService!"+TranslatorServiceRemote.class.getCanonicalName();
	private TranslatorServiceRemote proxy;
	
	 private JPanel panel = new JPanel();
	 private JLabel frenchLabel = new JLabel("french");
	 private JLabel blankLabel = new JLabel("");
	 private JLabel englishLabel = new JLabel("english");
	 private JTextField frenchField = new JTextField();
	 private JTextField englishField = new JTextField();
	 
	 private JButton translateButton = new JButton("translate");
	 
	 public DictionnaryApp() {
		 
		 try {
			proxy = (TranslatorServiceRemote) new InitialContext().lookup(jndiName);
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		 
		 setTitle("Dic");
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 init();
		 setVisible(true);
		 pack();
	 }
	 
	 














	private void init(){
		 
		 panel.setLayout(new GridLayout(2, 3));
		 panel.add(frenchLabel);
		 panel.add(blankLabel);
		 panel.add(englishLabel);
		 panel.add(frenchField);
		 panel.add(translateButton);
		 panel.add(englishField);
		 getContentPane().add(panel);
		 translateButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				englishField.setText(proxy.translate(frenchField.getText()));
			}
		});
	 }
	 
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new DictionnaryApp();
			}
		});
	}

}
