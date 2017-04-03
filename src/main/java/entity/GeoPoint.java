package entity;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class GeoPoint {

    private int idPoint;

    private double latitude;

    private double longitude;

    /**
     *
     * Default Constructor
     *
     */
    public GeoPoint() {
    }

    /**
     * Constructor
     *
     * @param latitude  - Double latitude
     * @param longitude - Double longitude
     */
    public GeoPoint(int idGeoPoint, double latitude, double longitude)
    {
        this.idPoint = idGeoPoint;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLotitude()
    {
        return latitude;
    }

    public double getLongtude()
    {
        return longitude;
    }

    public int getIdPoint() {
        return idPoint;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "idPoint=" + idPoint +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
