package classes;

public class Vol {
    public int numero;
    public int départ;
    public int arrivée;
    public int altitude;
    public int idavion;
    public int heuredépart;
    public int heureArrivée;
    public Avion avion;
   
    public Vol(int numero, int départ, int arrivée, int altitude, int heuredépart,
            int heureArrivée,Avion avion) {
        this.numero = numero;
        this.départ = départ;
        this.arrivée = arrivée;
        this.altitude = altitude;
        
        this.heuredépart = heuredépart;
        this.heureArrivée = heureArrivée;
        this.avion=avion;
    }
 public Vol() {
    	
    }
    
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public int getDépart() {
        return départ;
    }
    public void setDépart(int départ) {
        this.départ = départ;
    }
    
    
    
	public int getArrivée() {
        return arrivée;
    }
    public void setArrivée(int arrivée) {
        this.arrivée = arrivée;
    }
    public int getAltitude() {
        return altitude;
    }
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
    
    public int getHeuredépart() {
        return heuredépart;
    }
    public void setHeuredépart(int heuredépart) {
        this.heuredépart = heuredépart;
    }
    public int getHeureArrivée() {
        return heureArrivée;
    }
    public void setHeureArrivée(int heureArrivée) {
        this.heureArrivée = heureArrivée;
    }
	
	
	public Avion getAvion() {
		return avion;
	}


    
}