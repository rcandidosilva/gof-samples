package hopp;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
public class CalendarImpl implements Calendar{
    private static final String REMOTE_SERVICE = "calendarimpl";
    private static final String DEFAULT_FILE_NAME = "calendar.ser";
    private HashMap appointmentCalendar = new HashMap();
    
    public CalendarImpl(){
        this(DEFAULT_FILE_NAME);
    }
    public CalendarImpl(String filename){
        File inputFile = new File(filename);
        appointmentCalendar = (HashMap)FileLoader.loadData(inputFile);
        if (appointmentCalendar == null){
            appointmentCalendar = new HashMap();
        }
        try {
            UnicastRemoteObject.exportObject(this);
            Naming.rebind(REMOTE_SERVICE, this);
        }
        catch (Exception exc){
            System.err.println("Error using RMI to register the CalendarImpl " + exc);
        }
    }
    
    public String getHost(){ return ""; }
    public ArrayList getAppointments(Date date){
        ArrayList returnValue = null;
        Long appointmentKey = new Long(date.getTime());
        if (appointmentCalendar.containsKey(appointmentKey)){
            returnValue = (ArrayList)appointmentCalendar.get(appointmentKey);
        }
        return returnValue;
    }
    
    public void addAppointment(Appointment appointment, Date date){
        Long appointmentKey = new Long(date.getTime());
        if (appointmentCalendar.containsKey(appointmentKey)){
            ArrayList appointments = (ArrayList)appointmentCalendar.get(appointmentKey);
            appointments.add(appointment);
        }
        else {
            ArrayList appointments = new ArrayList();
            appointments.add(appointment);
            appointmentCalendar.put(appointmentKey, appointments);
        }
    }
}