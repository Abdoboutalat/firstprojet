package Exercice1_Q5;

import java.io.*; 
import java.net.*; 
 
public class ClientTCP { 
 /**
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception 
   { 
		  
		 try {
			 
			 Socket socketClient = new Socket("localhost", 2009); 
			 //Socket socketClient = new Socket(adr, 7000);
			 
			 boolean test=true;
			 String phrase; 
			 BufferedReader entreeDepuisUtilisateur;
			 BufferedReader entreeDepuisServeur;
			 PrintWriter sortieVersServeur;
			 System.out.println("client >> saisir votre message :");
			 while(test) {					  				  	
				 entreeDepuisUtilisateur =new BufferedReader(new 
				                                    InputStreamReader(System.in));		 
				 phrase = entreeDepuisUtilisateur .readLine();				 				 
				 sortieVersServeur =new PrintWriter(socketClient.getOutputStream()); 
				 
				 sortieVersServeur.println(phrase); 
				 sortieVersServeur.flush();  //  vider le tompon
				 if(phrase.equals("END"))
					 test=false;
				 else {
					 entreeDepuisServeur=new BufferedReader( new 
				    		 	InputStreamReader(socketClient.getInputStream()) ); 
				  
				                String recept= entreeDepuisServeur.readLine(); 
				                System.out.println(" la réponse du serveur : "+ recept); 
				 }
			 }
			 socketClient.close(); 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				 		 		 				
    } 
} 