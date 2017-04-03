package entity;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public enum TransportType {
    TRAM("Tram"), BUS("Bus"), TROLLEYBUS("Trolleybus");

   static Integer idType;
    String type;

//
//    TransportType(String value_1, String value_2) {
//        this.nameRu = value_1;
//        this.nameEn = value_2;
//    }

    TransportType(String type){
        this.type = type;
    }

//
//    TransportType(int idType, String value_1, String value_2) {
//        this.nameRu = value_1;
//        this.nameEn = value_2;
//        this.idType = idType;
//    }


    public static void setIdType(int newId) {
        idType = newId;
    }

    public static int getIdType() {
        return idType;
    }


    @Override
    public String toString() {
        return "TransportType{" +
                "idType=" + idType +
                ", transportType=" + type +
                '}';
    }
}
