package hopp;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;
public class CalendarHOPP implements Calendar, java.io.Serializable{
    private static final String PROTOCOL = "rmi://";
    private static final String REMOTE_SERVICE = "/calendarimpl";
    private static final String HOPP_SERVICE = "calendar";
    private static final String DEFAULT_HOST = "localhost";
    private Calendar calendar;
    private String host;
    
    public CalendarHOPP(){
        this(DEFAULT_HOST);
    }
    public CalendarHOPP(String host){
        try {
            this.host = host;
            String url = PROTOCOL + host + REMOTE_SERVICE;
            calendar = (Calendar)Naming.lookup(url);
            Naming.rebind(HOPP_SERVICE, this);
        }
        catch (Exception exc){
            System.err.println("Error using RMI to look up the CalendarImpl or register the CalendarHOPP " + exc);
        }
    }
    
    public String getHost(){ return host; }
    public ArrayList getAppointments(Date date) throws RemoteException{ return calendar.getAppointments(date); }
    
    public void addAppointment(Appointment appointment, Date date) throws RemoteException { calendar.addAppointment(appointment, date); }
}