package entity;

/**
 * Created by valeriyartemenko on 31.03.17.
 */
public class TypeTransport {

    private int ID_TYPE;

    private String nameType;

    public TypeTransport(int id, String name){
        this.ID_TYPE = id;
        this.nameType = name;
    }

    public int getID_TYPE() {
        return ID_TYPE;
    }

    public String getNameType() {
        return nameType;
    }

    @Override
    public String toString() {
        return "TypeTransport{" +
                "ID_TYPE=" + ID_TYPE +
                ", nameType='" + nameType + '\'' +
                '}';
    }
}
