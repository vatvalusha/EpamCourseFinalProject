package entity;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class Stop {

    private int id_stop;

    private String nameEn;

    private String nameRu;

    private GeoPoint geoPoint;

    public Stop() {
    }

    /**
     *
     * Constructor:
     *
//     * @param id_stop  - route ID
     * @param nameEn   - stop English name
     * @param nameRu   - stop Russian name
     * @param geoPoint - geoPoint : Double latitude, Double longitude
     *
     */
    public Stop(int id_stop, String nameEn, String nameRu, GeoPoint geoPoint) {
        this.id_stop = id_stop;
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.geoPoint = geoPoint;
    }

    /**
     *
     * Constructor without id_stop, auto increment
     *
     * @param nameEn
     * @param nameRu
     * @param geoPoint
     */
    public Stop(String nameEn, String nameRu, GeoPoint geoPoint) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.geoPoint = geoPoint;
    }

    /**
     *
     * Constructor for Update DAO
     *
     * @param nameEn
     * @param nameRu
     */
    public Stop(String nameEn, String nameRu){
        this.nameEn = nameEn;
        this.nameRu = nameRu;
    }


    //Getter for our fields
    public int getId_stop() {
        return id_stop;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }


    @Override
    public String toString() {
        return "Stop{" +
                "id_stop=" + id_stop +
                ", nameEn='" + nameEn + '\'' +
                ", nameRu='" + nameRu + '\'' +
                ", geoPoint=" + geoPoint +
                '}';
    }

}
