package entity;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class Transport {

    private  int ID_TRANSPORT;

    private int numberTransport;

    private  String MODEL_NAME_RU;

    private  String MODEL_NAME_EN;

    private int capacity;

    private int idRoute;

    private TypeTransport typeTransport;


    /**
     *
     * Constructor
     *
     * @param ID_TRANSPORT
     * @param numberTransport
     * @param MODEL_NAME_RU
     * @param MODEL_NAME_EN
//     * @param transportType
     */
    public Transport(int ID_TRANSPORT, int numberTransport, int capacity,String MODEL_NAME_RU, String MODEL_NAME_EN, TypeTransport typeTransport, int idRoute) {
        this.ID_TRANSPORT = ID_TRANSPORT;
        this.numberTransport = numberTransport;
        this.MODEL_NAME_RU = MODEL_NAME_RU;
        this.MODEL_NAME_EN = MODEL_NAME_EN;
        this.capacity = capacity;
        this.idRoute = idRoute;
        this.typeTransport = typeTransport;
    }
    public Transport(int numberTransport, int capacity,String MODEL_NAME_RU, String MODEL_NAME_EN, TypeTransport typeTransport) {
        this.numberTransport = numberTransport;
        this.MODEL_NAME_RU = MODEL_NAME_RU;
        this.MODEL_NAME_EN = MODEL_NAME_EN;
        this.capacity = capacity;
//        this.transportType = transportType;
//        this.idRoute = idRoute;
        this.typeTransport = typeTransport;
    }
    public Transport(int idTransport){
        this.ID_TRANSPORT = idTransport;
    }

    //Getters for fields
    public int getID_TRANSPORT() {
        return ID_TRANSPORT;
    }

    public int getNumberTransport() {
        return numberTransport;
    }

    public String getMODEL_NAME_RU() {
        return MODEL_NAME_RU;
    }

    public String getMODEL_NAME_EN() {
        return MODEL_NAME_EN;
    }


    public int getCapacity() {
        return capacity;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (ID_TRANSPORT != transport.ID_TRANSPORT) return false;
        if (numberTransport != transport.numberTransport) return false;
        if (capacity != transport.capacity) return false;
        if (MODEL_NAME_RU != null ? !MODEL_NAME_RU.equals(transport.MODEL_NAME_RU) : transport.MODEL_NAME_RU != null)
            return false;
        if (MODEL_NAME_EN != null ? !MODEL_NAME_EN.equals(transport.MODEL_NAME_EN) : transport.MODEL_NAME_EN != null)
            return false;
        return typeTransport != null ? typeTransport.equals(transport.typeTransport) : transport.typeTransport == null;
    }

    @Override
    public int hashCode() {
        int result = ID_TRANSPORT;
        result = 31 * result + numberTransport;
        result = 31 * result + (MODEL_NAME_RU != null ? MODEL_NAME_RU.hashCode() : 0);
        result = 31 * result + (MODEL_NAME_EN != null ? MODEL_NAME_EN.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (typeTransport != null ? typeTransport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "ID_TRANSPORT=" + ID_TRANSPORT +
                ", numberTransport=" + numberTransport +
                ", MODEL_NAME_RU='" + MODEL_NAME_RU + '\'' +
                ", MODEL_NAME_EN='" + MODEL_NAME_EN + '\'' +
                ", capacity=" + capacity +
                ", typeTransport=" + typeTransport +
                '}';
    }
}
