package builder;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
public class RunPattern{
    private static Calendar dateCreator = Calendar.getInstance();
    
    public static void main(String [] arguments){
        Appointment appt = null;
        
        System.out.println("Example for the Builder pattern");
        System.out.println();
        System.out.println("This example demonstrates the use of the Builder");
        System.out.println("pattern to create Appointment objects for the PIM.");
        System.out.println();
        
        System.out.println("Creating a Scheduler for the example.");
        Scheduler pimScheduler = new Scheduler();
        
        System.out.println("Creating an AppointmentBuilder for the example.");
        System.out.println();
        AppointmentBuilder apptBuilder = new AppointmentBuilder();
        try{
            System.out.println("Creating a new Appointment with an AppointmentBuilder");
            appt = pimScheduler.createAppointment(
                apptBuilder, createDate(2066, 9, 22, 12, 30),
                null, "Trek convention", new LocationImpl("Fargo, ND"),
                createAttendees(4));
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
        }
        catch (InformationRequiredException exc){
            printExceptions(exc);
        }
        
        System.out.println("Creating a MeetingBuilder for the example.");
        MeetingBuilder mtgBuilder = new MeetingBuilder();
        try{
            System.out.println("Creating a new Appointment with a MeetingBuilder");
            System.out.println("(notice that the same create arguments will produce");
            System.out.println(" an exception, since the MeetingBuilder enforces a");
            System.out.println(" mandatory end date)");
            appt = pimScheduler.createAppointment(
                mtgBuilder, createDate(2066, 9, 22, 12, 30),
                null, "Trek convention", new LocationImpl("Fargo, ND"),
                createAttendees(4));
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
        }
        catch (InformationRequiredException exc){
            printExceptions(exc);
        }
        
        System.out.println("Creating a new Appointment with a MeetingBuilder");
        System.out.println("(This time, the MeetingBuilder will provide an end date)");
        try{
            appt = pimScheduler.createAppointment(
                mtgBuilder,
                createDate(2002, 4, 1, 10, 00),
                createDate(2002, 4, 1, 11, 30),
                "OOO Meeting",
                new LocationImpl("Butte, MT"),
                createAttendees(2));
            System.out.println("Successfully created an Appointment.");
            System.out.println("Appointment information:");
            System.out.println(appt);
            System.out.println();
        }
        catch (InformationRequiredException exc){
            printExceptions(exc);
        }
    }
    
    public static Date createDate(int year, int month, int day, int hour, int minute){
        dateCreator.set(year, month, day, hour, minute);
        return dateCreator.getTime();
    }
    
    public static ArrayList createAttendees(int numberToCreate){
        ArrayList group = new ArrayList();
        for (int i = 0; i < numberToCreate; i++){
            group.add(new ContactImpl("John", getLastName(i), "Employee (non-exempt)", "Yoyodyne Corporation"));
        }
        return group;
    }
    
    public static String getLastName(int index){
        String name = "";
        switch (index % 6){
            case 0: name = "Worfin";
                break;
            case 1: name = "Smallberries";
                break;
            case 2: name = "Bigbootee";
                break;
            case 3: name = "Haugland";
                break;
            case 4: name = "Maassen";
                break;
            case 5: name = "Sterling";
                break;
        }
        return name;
    }
    
    public static void printExceptions(InformationRequiredException exc){
        int statusCode = exc.getInformationRequired();
        
        System.out.println("Unable to create Appointment: additional information is required");
        if ((statusCode & InformationRequiredException.START_DATE_REQUIRED) > 0){
            System.out.println("  A start date is required for this appointment to be complete.");
        }
        if ((statusCode & InformationRequiredException.END_DATE_REQUIRED) > 0){
            System.out.println("  An end date is required for this appointment to be complete.");
        }
        if ((statusCode & InformationRequiredException.DESCRIPTION_REQUIRED) > 0){
            System.out.println("  A description is required for this appointment to be complete.");
        }
        if ((statusCode & InformationRequiredException.ATTENDEE_REQUIRED) > 0){
            System.out.println("  At least one attendee is required for this appointment to be complete.");
        }
        if ((statusCode & InformationRequiredException.LOCATION_REQUIRED) > 0){
            System.out.println("  A location is required for this appointment to be complete.");
        }
        System.out.println();
    }
}