package hopp;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
public class Appointment implements Serializable{
    private String description;
    private ArrayList contacts;
    private Location location;
    private Date startDate;
    private Date endDate;

    public Appointment(String description, ArrayList contacts, Location location, Date startDate, Date endDate){
        this.description = description;
        this.contacts = contacts;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getDescription(){ return description; }
    public ArrayList getContacts(){ return contacts; }
    public Location getLocation(){ return location; }
    public Date getStartDate(){ return startDate; }
    public Date getEndDate(){ return endDate; }
    
    public void setDescription(String description){ this.description = description; }
    public void setContacts(ArrayList contacts){ this.contacts = contacts; }
    public void setLocation(Location location){ this.location = location; }
    public void setStartDate(Date startDate){ this.startDate = startDate; }
    public void setEndDate(Date endDate){ this.endDate = endDate; }
    
    public String toString(){
        return "Appointment:" + "\n    Description: " + description +
		"\n    Location: " + location + "\n    Start: " +
            startDate + "\n    End: " + endDate + "\n";
    }
}