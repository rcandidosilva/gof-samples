package builder;

public class InformationRequiredException extends Exception{
    private static final String MESSAGE = "Appointment cannot be created because further information is required";
    public static final int START_DATE_REQUIRED = 1;
    public static final int END_DATE_REQUIRED = 2;
    public static final int DESCRIPTION_REQUIRED = 4;
    public static final int ATTENDEE_REQUIRED = 8;
    public static final int LOCATION_REQUIRED = 16;
    private int informationRequired;
    
    public InformationRequiredException(int itemsRequired){
        super(MESSAGE);
        informationRequired = itemsRequired;
    }
    
    public int getInformationRequired(){ return informationRequired; }
}