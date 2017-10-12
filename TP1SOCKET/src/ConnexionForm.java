import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConnexionForm extends JFrame {

	
	//modificatio
	private JLabel bonjour;
	private JLabel lnom;
	private JTextField tNom;	
	private JLabel lpass;
	private JTextField tpass;
	private JButton bclick;
	private JButton bInscription;
	
	public ConnexionForm() {		
		super();
		
		inisialize();
		evenments();
		ajouterComposants();
		this.setBounds(700, 300, 600, 200);		
		this.setVisible(true);
	}
	
	public void inisialize() {
		bonjour = new JLabel("Connexion ");
		lnom = new JLabel("Nom : ");
		tNom = new JTextField();		
		lpass = new JLabel("password : ");
		tpass = new JTextField();
		bclick = new JButton("Connexion");
		bInscription = new JButton("Inscription");
	}
	
	public void ajouterComposants() {
        
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(bonjour);
		

		JPanel pcenter = new JPanel();
		pcenter.setLayout(new GridLayout(3, 2));
		pcenter.add(lnom);
		pcenter.add(tNom);		
		pcenter.add(lpass);
		pcenter.add(tpass);
	
				       
		JPanel psouth = new JPanel();
		psouth.setLayout(new FlowLayout());
		psouth.add(bclick);
		psouth.add(bInscription);
		
		
		this.add(p1, BorderLayout.NORTH);
		this.add(pcenter, BorderLayout.CENTER);
		this.add(psouth, BorderLayout.SOUTH);
	}
	
    private void evenments(){
    	bclick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								close();					
			}
		});
    	bInscription.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {												
				close();				
			}
		});
    }
	    
    public  void close() {
		this.dispose();		
	}
	public ConnexionForm moi(){
		return this;
	}
	
	public static void main(String[] args) {
		ConnexionForm f = new ConnexionForm();							
	}	
	
}
