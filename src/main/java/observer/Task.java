package observer;

public class Task{
    private String name = "";
    private String notes = "";
    private double timeRequired;
    
    public Task(){ }
    public Task(String newName, String newNotes, double newTimeRequired){
        name = newName;
        notes = newNotes;
        timeRequired = newTimeRequired;
    }
    
    public String getName(){ return name; }
    public String getNotes(){ return notes; }
    public double getTimeRequired(){ return timeRequired; }
    public void setName(String newName){ name = newName; }
    public void setTimeRequired(double newTimeRequired){ timeRequired = newTimeRequired; }
    public void setNotes(String newNotes){ notes = newNotes; }
    public String toString(){ return name + " " + notes; }
}