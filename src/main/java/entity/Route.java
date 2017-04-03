package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class Route {

    private int routeId;

    private String name_route_ru;

    private String name_route_en;

    private Transport transport;

    private List<Stop> stopList;

    private List<Transport> transportList;

    /**
     * Default constructor
     */
    public Route() {
    }


    /**
     *
     * Constructor
     *
     * @param routeId       - int route ID
     * @param name_route_ru - String English route name
     * @param name_route_en - String Russian route name
     *
     */
    public Route(int routeId, String name_route_ru, String name_route_en, Transport transport) {
        this.routeId = routeId;
        this.name_route_ru = name_route_ru;
        this.name_route_en = name_route_en;
        this.transport = transport;
        transportList = new ArrayList<>();
        stopList = new ArrayList<>();
    }
    public Route(Transport transport,String name_route_ru, String name_route_en) {
        this.name_route_ru = name_route_ru;
        this.name_route_en = name_route_en;
        this.transport = transport;
        transportList = new ArrayList<>();
        stopList = new ArrayList<>();
    }

    //Getting for params
    public int getRouteId() {
        return routeId;
    }

    public String getName_route_ru() {
        return name_route_ru;
    }

    public String getName_route_en() {
        return name_route_en;
    }

    public List<Stop> getStopList() {
        return stopList;
    }

    public List<Transport> getTransportList() {
        return transportList;
    }

    public Transport getTransport() {
        return transport;
    }

    //Setters
    public void setStopList(List<Stop> stopList) {
        this.stopList = stopList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    //add entity
    public void addtransport(Transport transport){
        transportList.add(transport);
    }

    public void addStop(Stop stop){
        stopList.add(stop);
    }

    //remove entity
    public void removeTransport(Transport transport){
        transportList.remove(transport);
    }

    public void removeStop(Stop stop){
        stopList.remove(stop);
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", name_route_ru='" + name_route_ru + '\'' +
                ", name_route_en='" + name_route_en + '\'' +
                ", transport=" + transport +
                '}';
    }
}
