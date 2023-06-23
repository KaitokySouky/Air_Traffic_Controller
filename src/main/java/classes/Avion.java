package classes;
import java.io.IOException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Avion{
	public int idavion;
	public String type;
	public double consommation;
	public  double capacité;  
	public final double vitesse=200;
	//private  int idaeroport;
	public Point position;
    public Aeroport aeroport;
 
    public Avion(int idavion,String type, double consommation, double capacité,Aeroport aeroport ) {
        this.idavion=idavion;
    	this.type = type;
        this.consommation = consommation;
        this.capacité = capacité;
        this.aeroport=aeroport;
      
    }
    
    
    public Avion() {
    	
    }
    
    public int getIdavion() {
		return idavion;
	}


	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}


	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
/*
	public int getIdaeroport() {
		return idaeroport;
	}

	public void setIdaeroport(int idaeroport) {
		this.idaeroport = idaeroport;
	}*/

	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}

	public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getConsommation() {
        return consommation;
    }
 /*   public void setConsommation(int consommation) {
        this.consommation = consommation;
    }*/
    public double getCapacité() {
        return capacité;
    }
    public void setCapacité(double capacité) {
        this.capacité = capacité;
    }
    public Double getVitesse() {
        return vitesse;
    }
 
    public double consomm(double distance){
      
        double temps = distance/vitesse;
        consommation = temps*consommation;
        
       
        return consommation;
    
}
public Point getPosition() {
    return position;
}
public void setPosition(Point position) {
    this.position = position;
}
public boolean peutEffectueVol(double distance){

    double consomm = consomm(distance);


    return consomm <= capacité;

}
public Point getPositions(String adresse){
    try {
        //départ: Latitude: 33.92909535  Longitude: -4.979092897666969
//   String address ="Aéroport Fes Saïss Oulad Tayeb, Fes 30000";
        //arrivée
    String address =adresse; //Latitude: 34.02236   Longitude: -6.8340222

    address = URLEncoder.encode(address, "UTF-8"); // encode l'adresse en URL pour être utilisé dans l'API de Nominatim

    URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + address + "&format=json&addressdetails=1&limit=1");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    int responseCode = connection.getResponseCode();
    BufferedReader in = new BufferedReader(
    new InputStreamReader(
    connection.getInputStream()));
    if (responseCode == 200) {
    String response = "";
    String line;
    while ((line =  in.readLine()) != null) {
    response += line;
    }




    JSONArray jsonResponse = new JSONArray(response);
    if (jsonResponse.length() > 0) {
    JSONObject location = jsonResponse.getJSONObject(0);
    double latitude = location.getDouble("lat");
    double longitude = location.getDouble("lon");
    /*System.out.println("Latitude: " + latitude);
    System.out.println("Longitude: " + longitude);*/
    this.position=new Point(latitude,longitude);
    return position;
    } else {
    System.out.println("Adresse introuvable.");
    }
    } else {
    System.out.println("Erreur: " + responseCode);
    }
    } catch (IOException | JSONException e) {
    System.out.println("Erreur: " + e.getMessage());
    }
    return new Point();




    
}
}
