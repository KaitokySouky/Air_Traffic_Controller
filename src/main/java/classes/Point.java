package classes;
import java.util.concurrent.atomic.DoubleAdder;

public class Point {


    private double latitude;
    private double longitude;

    public Point(){

    }
    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @Override
    public String toString(){
      return "longitude c'est: "+this.longitude+" latitude c'est: "+this.latitude;
    }
    
}
