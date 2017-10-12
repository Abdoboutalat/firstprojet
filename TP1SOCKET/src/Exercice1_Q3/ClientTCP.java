package Exercice1_Q3;
import java.io.*; 
import java.net.*; 

public class ClientTCP { 
   public static void main(String[] args) throws Exception 
   { 
		  
		 try {
			  
			 Socket socketClient = new Socket("localhost", 7003);
				//Socket socketClient = new Socket(adr, 7000); 
			 
			 String phrase; 			 
			 System.out.println("client >> saisir votre message :"); 
			 
			 BufferedReader entreeDepuisUtilisateur =new BufferedReader(new 
			                                    InputStreamReader(System.in));
			 
			 phrase = entreeDepuisUtilisateur .readLine(); 
			 
			 PrintWriter sortieVersServeur =new PrintWriter(socketClient.getOutputStream()); 
			 
			 sortieVersServeur.println(phrase); 
			 sortieVersServeur.flush();  //  vider le tompon
			 socketClient.close(); 
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		 		 		 		 			
    } 
}   