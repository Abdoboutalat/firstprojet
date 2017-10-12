package Exercice2;

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
			 
			 while(test) {
				 
				 entreeDepuisServeur=new BufferedReader( new 
    		 	InputStreamReader(socketClient.getInputStream()) ); 
  
                String recept= entreeDepuisServeur.readLine(); 
                System.out.println( recept); 
			     if(recept.startsWith(" la somme est")) {
			    	 test=false;
			     }else {
			    	 entreeDepuisUtilisateur =new BufferedReader(new 
                             InputStreamReader(System.in));		 
					phrase = entreeDepuisUtilisateur .readLine();				 				 
					sortieVersServeur =new PrintWriter(socketClient.getOutputStream()); 
					
					sortieVersServeur.println(phrase); 
					sortieVersServeur.flush();  //  vider le tompon	
			     }
				 			 			 
			 }
			 socketClient.close(); 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				 		 		 				
    } 
} 