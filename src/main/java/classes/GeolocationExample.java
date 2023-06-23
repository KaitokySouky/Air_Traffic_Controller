package classes;
import java.io.IOException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
public class GeolocationExample {
    public static void main(String[] args) {
        try {
                           //départ: Latitude: 33.92909535  Longitude: -4.979092897666969
            //   String address ="Aéroport Fes Saïss Oulad Tayeb, Fes 30000";
                           //arrivée
             String address ="Rue du Jura, 17000 La Rochelle, France"; //9CF9+6CW Terminal 1, Rte de Nouasseur, Nouaceur  Rabat, Salé   Latitude: 34.02236   Longitude: -6.8340222

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
                    System.out.println("Latitude: " + latitude);
                    System.out.println("Longitude: " + longitude);
                } else {
                    System.out.println("Adresse introuvable.");
                }
            } else {
                System.out.println("Erreur: " + responseCode);
            }
        } catch (IOException | JSONException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

     
        
    }}

   





