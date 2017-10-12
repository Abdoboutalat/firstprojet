package Exercice2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class ClientTCPForm extends JFrame {
	
	private JLabel bonjour;
	private JLabel labelMessage;
	private JLabel labelMessageOperation;
	private JTextField textNombre;			
	private JButton bclick;
	
	 Socket socketClient;
	 boolean test=true;
	 String phrase; 
	 BufferedReader entreeDepuisServeur;
	 PrintWriter sortieVersServeur;
	 
	public ClientTCPForm() {		
		super();
		
		inisialize();
		evenments();
		ajouterComposants();
		this.setBounds(700, 300, 600, 200);		
		this.setVisible(true);
	}
	
	public void inisialize() {
		bonjour = new JLabel("Connexion ");
		labelMessage = new JLabel("operation : ");
		labelMessageOperation= new JLabel();
		textNombre = new JTextField();						
		bclick = new JButton("valider");
		
		labelMessageOperation.setVisible(true);
		try {
			
			 socketClient = new Socket("localhost", 2009);
			bonjour.setText("Client est connecté au serveur ");
			 entreeDepuisServeur=new BufferedReader( new 
    		 	InputStreamReader(socketClient.getInputStream()) );   
                String recept= entreeDepuisServeur.readLine();                 
                labelMessage.setText(recept);
                
		} catch (Exception e) {
			bonjour.setText("Client ne peut pas se connecter au serveur");
			labelMessage.setVisible(false);
			textNombre.setVisible(false);
			bclick.setVisible(false);
			 
		} 
								
	}
	
	public void ajouterComposants() {
        
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(bonjour);					
		
		
		JPanel pcenter = new JPanel();
		
		pcenter.setLayout(new GridLayout(3, 2));
		pcenter.add(labelMessageOperation);
		pcenter.add(labelMessage);
		pcenter.add(textNombre);		
							       
		JPanel psouth = new JPanel();
		psouth.setLayout(new FlowLayout());
		psouth.add(bclick);
		 
		
		this.add(p1, BorderLayout.NORTH);					
		this.add(pcenter, BorderLayout.CENTER);
		this.add(psouth, BorderLayout.SOUTH);
	}
	
    private void evenments(){
    	bclick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {		
				    	phrase = textNombre.getText(); 	 
						sortieVersServeur =new PrintWriter(socketClient.getOutputStream()); 
						
						sortieVersServeur.println(phrase); 
						sortieVersServeur.flush();  //  vider le tompon
						 entreeDepuisServeur=new BufferedReader( new 
		    		 	InputStreamReader(socketClient.getInputStream()) );   
		                String recept= entreeDepuisServeur.readLine();                 
		                
		                if(!recept.startsWith("Entrer")) {
		                	 labelMessageOperation.setText(labelMessageOperation.getText()+" = "+recept);		                	 
					    	 textNombre.setVisible(false);
					    	 bclick.setVisible(false);
					    	 labelMessage.setText("La somme est : "+recept);
					    	 bonjour.setText("Client deconnecté");
					     }else {
					    	 labelMessage.setText(recept);
					    	 if(labelMessageOperation.getText().isEmpty())
					    	   labelMessageOperation.setText(phrase);
					    	 else
					    		 labelMessageOperation.setText(labelMessageOperation.getText()+" + "+phrase);
					    	     textNombre.setText("");
					     }
//				     }
					
					//bonjour.setText("dfdfdf");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				 				 
				
			  //close();					
			}
		});    
    	
    }
	    
    public  void close() {
    	try {
			socketClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.dispose();		
	}
	public ClientTCPForm moi(){
		return this;
	}
	
	public static void main(String[] args) {
		ClientTCPForm f = new ClientTCPForm();							
	}	
	
}
