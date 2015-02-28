package builder;

import java.util.ArrayList;
import java.util.Date;
public class Appointment{
    private Date startDate;
    private Date endDate;
    private String description;
    private ArrayList attendees = new ArrayList();
    private Location location;
    public static final String EOL_STRING =
        System.getProperty("line.separator");
    
    public Date getStartDate(){ return startDate; }
    public Date getEndDate(){ return endDate; }
    public String getDescription(){ return description; }
    public ArrayList getAttendees(){ return attendees; }
    public Location getLocation(){ return location; }

    public void setDescription(String newDescription){ description = newDescription; }
    public void setLocation(Location newLocation){ location = newLocation; }
    public void setStartDate(Date newStartDate){ startDate = newStartDate; }
    public void setEndDate(Date newEndDate){ endDate = newEndDate; }
    public void setAttendees(ArrayList newAttendees){
        if (newAttendees != null){
            attendees = newAttendees;
        }
    }
    
    public void addAttendee(Contact attendee){
        if (!attendees.contains(attendee)){
            attendees.add(attendee);
        }
    }
    
    public void removeAttendee(Contact attendee){
        attendees.remove(attendee);
    }
    
    public String toString(){
        return "  Description: " + description + EOL_STRING +
            "  Start Date: " + startDate + EOL_STRING +
            "  End Date: " + endDate + EOL_STRING +
            "  Location: " + location + EOL_STRING +
            "  Attendees: " + attendees;
    }
}