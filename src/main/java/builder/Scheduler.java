package builder;

import java.util.Date;
import java.util.ArrayList;
public class Scheduler{
    public Appointment createAppointment(AppointmentBuilder builder,
        Date startDate, Date endDate, String description,
        Location location, ArrayList attendees) throws InformationRequiredException{
            if (builder == null){
                builder = new AppointmentBuilder();
            }
        builder.buildAppointment();
        builder.buildDates(startDate, endDate);
        builder.buildDescription(description);
        builder.buildAttendees(attendees);
        builder.buildLocation(location);
        return builder.getAppointment();
    }
}