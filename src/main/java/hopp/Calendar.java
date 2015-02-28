package hopp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;
public interface Calendar extends Remote{
    public String getHost() throws RemoteException;
    public ArrayList getAppointments(Date date) throws RemoteException;
    public void addAppointment(Appointment appointment, Date date) throws RemoteException;
}