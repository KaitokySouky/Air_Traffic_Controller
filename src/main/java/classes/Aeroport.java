package classes;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Aeroport{
	private int idaeroport;	
	public String nom;
	public String localisation;
	public int nbrePiste;
	public Point position;
    public int nbreSol;
    public int attenteAuSol;
    public int accèsAuPiste;
    public int délaiAnticollision;
    public int tempsdécollage;
    public int tempsatterissage;
    public int duréeboucle;
    public List<Integer> distance;
public List<Avion> avions;
  
    public Aeroport(int idaeroport,String nom, String localisation, int nbrePiste, int nbreSol, int attenteAuSol, int accèsAuPiste,
            int délaiAnticollision, int tempsdécollage, int tempsatterissage, int duréeboucle) {
    	this.idaeroport=idaeroport;
        this.nom = nom;
        this.localisation = localisation;
        this.nbrePiste = nbrePiste;
        this.nbreSol = nbreSol;
        this.attenteAuSol = attenteAuSol;
        this.accèsAuPiste = accèsAuPiste;
        this.délaiAnticollision = délaiAnticollision;
        this.tempsdécollage = tempsdécollage;
        this.tempsatterissage = tempsatterissage;
        this.duréeboucle = duréeboucle;
   
        
        
    }
  public Aeroport() {
    	
    }
   

	



	public int getIdaeroport() {
	return idaeroport;
}
public void setIdaeroport(int idaeroport) {
	this.idaeroport = idaeroport;
}
public Point getPosition() {
	return position;
}
public void setPosition(Point position) {
	this.position = position;
}
	public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public int getNbrePiste() {
        return nbrePiste;
    }
    public void setNbrePiste(int nbrePiste) {
        this.nbrePiste = nbrePiste;
    }
    public int getNbreSol() {
        return nbreSol;
    }
    public void setNbreSol(int nbreSol) {
        this.nbreSol = nbreSol;
    }
    public int getAttenteAuSol() {
        return attenteAuSol;
    }
    public void setAttenteAuSol(int attenteAuSol) {
        this.attenteAuSol = attenteAuSol;
    }
    public int getAccèsAuPiste() {
        return accèsAuPiste;
    }
    public void setAccèsAuPiste(int accèsAuPiste) {
        this.accèsAuPiste = accèsAuPiste;
    }
    public int getDélaiAnticollision() {
        return délaiAnticollision;
    }
    public void setDélaiAnticollision(int délaiAnticollision) {
        this.délaiAnticollision = délaiAnticollision;
    }
    public int getTempsdécollage() {
        return tempsdécollage;
    }
    public void setTempsdécollage(int tempsdécollage) {
        this.tempsdécollage = tempsdécollage;
    }
    public int getTempsatterissage() {
        return tempsatterissage;
    }
    public void setTempsatterissage(int tempsatterissage) {
        this.tempsatterissage = tempsatterissage;
    }
    public int getDuréeboucle() {
        return duréeboucle;
    }
    public void setDuréeboucle(int duréeboucle) {
        this.duréeboucle = duréeboucle;
    }
    public List<Integer> getDistance() {
        return distance;
    }
    public void setDistance(List<Integer> distance) {
        this.distance = distance;
    }
    public List<Avion> getAvions() {
        return avions;
    }
    public void setAvions(List<Avion> avions) {
        this.avions = avions;
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