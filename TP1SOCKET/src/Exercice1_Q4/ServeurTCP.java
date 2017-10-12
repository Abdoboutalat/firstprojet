package Exercice1_Q4;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.*; 
  
public class ServeurTCP { 
  
public static void main(String[] args){ 
		ServerSocket socketServeur=null; 
		Socket socket=null; 
		try { 
				socketServeur = new ServerSocket(2009); 
				System.out.println("serveur prêt :"); 
				int nbrclient=0; 
				
				while(true){ 
					socket= socketServeur.accept(); 
					nbrclient++; 
					System.out.println("Le client numéro "+nbrclient+ " est connecté !"); 
					Thread t = new Thread(new Accepter_clients(socket, nbrclient)); 
					t.start(); 
				} 
		 
		} catch (IOException e) { 
		      e.printStackTrace(); 
		} 
    } 
} 
class Accepter_clients implements Runnable {  
    private Socket socket; 
    private int nbrclient; 
    public Accepter_clients(Socket s, int nucl){ 
	socket = s; 
	nbrclient=nucl; 
} 

  public void run() { 

               try {
            	        
            	   BufferedReader entreeDepuisClient=new BufferedReader( new 
                		 	InputStreamReader(socket.getInputStream()) ); 
              
	                String recept= entreeDepuisClient.readLine(); 
	                System.out.println(" le mess du client "+nbrclient +":"+ recept); 
                 
                    socket.close(); 
                    System.out.println("Client "+nbrclient+" diconnecté ");     
                } catch (IOException e) { 
                            e.printStackTrace(); 
                } 
              
     } 

} 