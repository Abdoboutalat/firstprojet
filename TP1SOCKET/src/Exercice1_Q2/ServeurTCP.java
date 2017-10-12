package Exercice1_Q2;
import java.io.*; 
import java.net.*; 
  
public class ServeurTCP{ 
	
    public static void main(String[] args) throws Exception 
      { 
   
		String recept; 
		int port= 7003;
		
		ServerSocket socketEcoute = new ServerSocket(port); 
		System.out.println("serveur prêt :");
		
		while (true) {
			
			Socket   socketService= socketEcoute.accept(); 			
			// affiche les coordonnées du client qui vient de se connecter 
			 System.out.println(" Ce client vient de se connecter:" +socketService.getInetAddress()+ 
			"/port:"+socketService.getPort()); 
			 
			// connexion acceptée : récupère les flux pour communiquer avec le client 
			BufferedReader entreeDepuisClient=new BufferedReader( 
			    new InputStreamReader(socketService.getInputStream()) ); 
			 			   
			recept= entreeDepuisClient.readLine(); 
			System.out.println("Réçu du client  : " +socketService.getInetAddress()+ 
					"/port:"+socketService.getPort()+ " le message :"+recept); 
			socketService.close();  
		}	 		 
    } 
} 