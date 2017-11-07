package view.ticket_office;

public class Zone {

    int idZone; //There r five zones: Broad, Copper, Silver, Gold, Diamond
    String zoneType;
    
    public Zone(String zoneType){
        this.zoneType = zoneType ;
    }

    public String getZoneType() {
        return zoneType;
    }
    
    
}
