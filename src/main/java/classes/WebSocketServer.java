package classes;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import classes.hibernateclass;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Scanner;
import classes.Vol;
import java.sql.*;
import java.util.*;

@ServerEndpoint("/WebSocketServer")

public class WebSocketServer {
	public static Map<String, ArrayList<Double> > fun(Graph graph,String departure ,String arrival,List<Aeroport> aeroports){
        Map<String, ArrayList<Double> > dict = new LinkedHashMap<>(); 
        List<String> shortestPath = graph.dijkstra(departure, arrival);
        
        
        int distance = graph.calculateDistance(shortestPath);
      //  System.out.println("Plus court chemin de " + departure + " à " + arrival + ":");
        for (String airport : shortestPath) {
            for(Aeroport a:aeroports){
                if(a.getNom().equals(airport)){
                    ArrayList array=new ArrayList<>();
                    array.add(a.getPositions(a.getLocalisation()).getLatitude());
                    array.add(a.getPositions(a.getLocalisation()).getLongitude());
                    dict.put(a.getNom(),array);
             
            
            break;  }
        }}
        
        System.out.println("Distance totale : "+distance);
    
         return dict;

    }
	
	
	@OnOpen
    public void onOpen(Session session) {
        // Code to handle connection establishment
		Graph graph = new Graph();
        List<Integer> distances=new ArrayList<>();
        Point point=new Point();
        
       
        
        
        
List<Aeroport> aeroports=new ArrayList<>();

Aeroport AéroportA =new Aeroport(1,"AeroportA", "6301 Silver Dart Dr, Mississauga, ON L5P 1B2, Canada", 
        5, 4, 20, 10, 6, 20,
         12, 10);

Aeroport AéroportB =new Aeroport(2,"AeroportB", "Rte de Trégastel, 22300 Lannion, France", 
        9, 9, 20, 10, 19, 20,
         12, 10);

         Aeroport AéroportC =new Aeroport(3,"AeroportC", "Victoria, Araucania, Chili", 
        7, 16, 20, 10, 12, 20,
         12, 10);

         Aeroport AéroportD =new Aeroport(4,"AeroportD", "23737 Ciudad Constitución, Baja California Sur, Mexique", 
        16, 6, 20, 10, 10, 20,
         12, 10);

         Aeroport AéroportE =new Aeroport(5,"AeroportE", "386 Yeosun-ro, Yulchon-myeon, Yeosu-si, Jeollanam-do, Corée du Sud", 
        18, 13, 20, 10, 10, 20,
         12, 10);

         Aeroport AéroportF =new Aeroport(6,"AeroportF", "Muş Merkez/Muş, Turquie", 
        3, 15, 20, 10, 13, 20,
         12, 10);
         
         
         
         
         Avion avion1=new Avion(1,"short",15,640,AéroportA);
         Avion avion2=new Avion(2,"long",16,850,AéroportA);
         
         Avion avion12=new Avion(3,"middle",12,760,AéroportB);
         Avion avion122=new Avion(4,"long",15,160,AéroportB);
         
         Avion avion13=new Avion(5,"short",26,970,AéroportC);
         Avion avion133=new Avion(6,"long",15,940,AéroportC);
         
         Avion avion14=new Avion(7,"middle",15,560,AéroportD);
         Avion avion144=new Avion(8,"short",15,990,AéroportD);
         
         Avion avion15=new Avion(9,"long",12,600,AéroportE);
         Avion avion155=new Avion(10,"middle",10,820,AéroportE);
         
         Avion avion16=new Avion(11,"long",16,700,AéroportF);
         Avion avion166=new Avion(12,"short",19,950,AéroportF);
         
         List<Avion> avions1=new ArrayList<>();
         List<Avion> avions2=new ArrayList<>();
         List<Avion> avions3=new ArrayList<>();
         List<Avion> avions4=new ArrayList<>();
         List<Avion> avions5=new ArrayList<>();
         List<Avion> avions6=new ArrayList<>();
         
         
         avions1.add(avion1);
         avions1.add(avion2);
         
         avions2.add(avion12);
         avions2.add(avion122);
         
         avions3.add(avion13);
         avions3.add(avion133);
         
         avions4.add(avion14);
         avions4.add(avion144);
         
         avions5.add(avion15);
         avions5.add(avion155);
         
         avions6.add(avion16);
         avions6.add(avion166);  
         
         
         
         AéroportA.setAvions(avions1);
         AéroportB.setAvions(avions2);
         AéroportC.setAvions(avions3);
         AéroportD.setAvions(avions4);
         
         AéroportE.setAvions(avions5);
         AéroportF.setAvions(avions6);
         
         
         
         
         
         
         
         
         
         
         
         aeroports.add(AéroportA);
         aeroports.add(AéroportB);
         aeroports.add(AéroportC);
         aeroports.add(AéroportD);
         aeroports.add(AéroportE);
         aeroports.add(AéroportF);

        // Ajouter des aéroports et leurs connexions avec les distances
        graph.addEdge(AéroportA.getNom(), AéroportB.getNom(), 5636);
        graph.addEdge(AéroportA.getNom(), AéroportC.getNom(), 9138);
        graph.addEdge(AéroportB.getNom(), AéroportD.getNom(), 9165);
        graph.addEdge(AéroportC.getNom(), AéroportD.getNom(), 8141);
        
        graph.addEdge(AéroportA.getNom(), AéroportD.getNom(), 3563);
        graph.addEdge(AéroportA.getNom(), AéroportE.getNom(), 10858);
        graph.addEdge(AéroportA.getNom(), AéroportF.getNom(), 9101);
        
        graph.addEdge(AéroportB.getNom(), AéroportC.getNom(), 11806);
        graph.addEdge(AéroportB.getNom(), AéroportE.getNom(), 9535);
        graph.addEdge(AéroportB.getNom(), AéroportF.getNom(), 3713);
        graph.addEdge(AéroportC.getNom(), AéroportA.getNom(), 9138);
        graph.addEdge(AéroportC.getNom(), AéroportF.getNom(), 14386);
        
        graph.addEdge(AéroportC.getNom(), AéroportE.getNom(), 18197);
        graph.addEdge(AéroportD.getNom(), AéroportE.getNom(), 10891);
        graph.addEdge(AéroportD.getNom(), AéroportF.getNom(), 12387);
        graph.addEdge(AéroportE.getNom(), AéroportF.getNom(), 7381);
		
     
       
     
    	        
        // Convert variables to JSON string
        try {
        	
            ObjectMapper objectMapper = new ObjectMapper();
            
            ArrayList chemins=new ArrayList<>();
            ArrayList getpistedepart=new ArrayList<>();
            ArrayList getpisteArrivee=new ArrayList<>();
           
            ArrayList placesausolarriv=new ArrayList<>();
            ArrayList placesausoldepart=new ArrayList<>();
            
            ArrayList Attenteausoldepart=new ArrayList<>();
            ArrayList Attenteausolarrivee=new ArrayList<>();
            
            ArrayList Accespistedepart=new ArrayList<>();
            ArrayList Accespistearrivee=new ArrayList<>();
            
            ArrayList anticollisiondepart=new ArrayList<>();
            ArrayList anticollisionarrive=new ArrayList<>();
            
            
            ArrayList capacite =new ArrayList<>();
            ArrayList consom =new ArrayList<>();
            ArrayList arrivees=new ArrayList<>();
            
          /** get vol from bdd*/
            List<Vol> volList =new ArrayList<>();
          
            String url = "jdbc:mysql://localhost:3304/simulator";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password); 
             volList = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM vol");
            while (resultSet.next()) {
                Vol vol = new Vol();
                vol.setDépart(resultSet.getInt("départ"));
                vol.setArrivée(resultSet.getInt("arrivée"));
                vol.setAltitude(resultSet.getInt("altitude"));
                
                vol.setHeuredépart(resultSet.getInt("heuredépart"));
                vol.setHeureArrivée(resultSet.getInt("heureArrivée"));
                volList.add(vol);
            }
            
            
            ArrayList<String> depart=new ArrayList<>();
            List<String> arrivee=new ArrayList<>();
            
          for(Vol e:volList) {
        	  PreparedStatement pstDepart = conn.prepareStatement("SELECT nom FROM aeroport WHERE idaeroport = ?");
        	    pstDepart.setInt(1, e.départ);
        	    ResultSet rsDepart = pstDepart.executeQuery();

        	    
        	    if (rsDepart.next()) {
        	        String depart1= rsDepart.getString("nom");
        	        depart.add(depart1);
        	    } 
        	  
        	 
            }
          
          for(Vol e:volList) {
        	  PreparedStatement pstDepart = conn.prepareStatement("SELECT nom FROM aeroport WHERE idaeroport = ?");
        	    pstDepart.setInt(1, e.arrivée);
        	    ResultSet rsDepart = pstDepart.executeQuery();

        	    
        	    if (rsDepart.next()) {
        	        String arrivee1= rsDepart.getString("nom");
        	        arrivee.add(arrivee1);
        	    } 
        	  
        	  
        	  
           
            }
          int size = volList.size();
         /** */ 
          for(int i=0;i<size;i++) { 
        	  Aeroport depart11=new Aeroport();
        	  Aeroport arrive11=new Aeroport();
        	  for(Aeroport e:aeroports) { 
        		 
        		  if(depart.get(i).equals(e.getNom())) {
        			  depart11=e;
        		  }
        		  
        		  if(arrivee.get(i).equals(e.getNom())) {
        			  arrive11=e;
        		  }
        	      
        	  }
         
            chemins.add(fun(graph, depart11.getNom(), arrive11.getNom(), aeroports));
            
        	  }
          
          for(int i=0;i<size;i++) { 
        	  Aeroport depart11=new Aeroport();
        	  Aeroport arrive11=new Aeroport();
        	  for(Aeroport e:aeroports) { 
        		 
        		  if(depart.get(i).equals(e.getNom())) {
        			  depart11=e;
        		  }
        		  }
            capacite.add(depart11.getAvions().get(0).capacité);
            consom.add(depart11.getAvions().get(0).consommation);
        	  }
          
         
            
       
          for(int i=0;i<size;i++) { 
        	  Aeroport depart11=new Aeroport();
        	  Aeroport arrive11=new Aeroport();
        	  for(Aeroport e:aeroports) { 
        		 
        		  if(depart.get(i).equals(e.getNom())) {
        			  depart11=e;
        		  }
        		  if(arrivee.get(i).equals(e.getNom())) {
        			  arrive11=e;
        		  }
        		  }
        	  getpistedepart.add(depart11.getNbrePiste());
        	  getpisteArrivee.add(arrive11.getNbrePiste());
        	  placesausolarriv.add(arrive11.getNbreSol());
        	  placesausoldepart.add(depart11.getNbreSol());
        	  Attenteausoldepart.add(depart11.getAttenteAuSol());
        	  Attenteausolarrivee.add(arrive11.getAttenteAuSol());
        	  
        	  Accespistedepart.add(depart11.getAccèsAuPiste());
        	  Accespistearrivee.add(arrive11.getAccèsAuPiste());
        	  anticollisiondepart.add(depart11.getDélaiAnticollision());
        	  anticollisionarrive.add(arrive11.getDélaiAnticollision());
        	  String address=arrive11.getLocalisation();
        	  
        	  String[] words = address.split(",");

              
              String lastWord = words[words.length - 1];
              arrivees.add(lastWord);
        	  
        	  }
          /***/
              
          
          /** */
          chemins.add(arrivees);
            chemins.add(getpistedepart);
            
            chemins.add(getpisteArrivee);
            
            
            chemins.add(placesausoldepart);

            chemins.add(placesausolarriv);
            
            /** */
            
            chemins.add(Attenteausoldepart);
            chemins.add(Attenteausolarrivee);
            chemins.add(Accespistedepart);
            chemins.add(Accespistearrivee);
            chemins.add(anticollisiondepart);
            chemins.add(anticollisionarrive);
            
            /** */
            
            chemins.add(capacite);
           // chemins.add(consom);
            System.out.println("les capacites sont:"+capacite);
           /* prendre les pays*/
            String address = "6301 Silver Dart Dr, Mississauga, ON L5P 1B2, Canada";

           
            String[] words = address.split(",");

            
            String lastWord = words[words.length - 1];

            System.out.println("Dernier mot : " + lastWord);
            
            
            
            
            
            int numberOfVertices = 6;
            int[][] a = new int[][]{
                {0, 5, 4, 20, 10, 6},
                {5, 0, 9, 9, 10, 19},
                {4, 9, 0, 16, 13, 15},
                {20, 9, 16, 0, 6, 10},
                {10, 10, 13, 6, 0, 7},
                {6, 19, 15, 10, 7, 0}
            };

            FordFulkerson fordFulkerson = new FordFulkerson(numberOfVertices);
            int source = 2;
            int goal = 3;
            int maxFlow = fordFulkerson.fordFulkerson(a, source, goal);
            System.out.println("Max des avions entre aeroportA et aeroportF: " + maxFlow);
        
            
            /*  */
           String json=objectMapper.writeValueAsString(chemins);
            
            // Send JSON string as text message
            session.getBasicRemote().sendText(json);

           
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	

    @OnMessage
    public void onMessage(String message,  Session session) {
        // Code to handle message reception
    }

    @OnClose
    public void onClose( Session session) {
        // Code to handle connection closure
    }
}
