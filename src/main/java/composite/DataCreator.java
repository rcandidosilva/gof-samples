package composite;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataCreator{
    private static final String DEFAULT_FILE = "data.ser";
    
    public static void main(String [] args){
        String fileName;
        if (args.length == 1){
            fileName = args[0];
        }
        else{
            fileName = DEFAULT_FILE;
        }
        serialize(fileName);
    }
    
    public static void serialize(String fileName){
        try{
            serializeToFile(createData(), fileName);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
    
    private static Serializable createData(){
        Contact contact1 = new ContactImpl("Dennis", "Moore", "Managing Director", "Highway Man, LTD");
        Contact contact2 = new ContactImpl("Joseph", "Mongolfier", "High Flyer", "Lighter than Air Productions");
        Contact contact3 = new ContactImpl("Erik", "Njoll", "Nomad without Portfolio", "Nordic Trek, Inc.");
        Contact contact4 = new ContactImpl("Lemming", "", "Principal Investigator", "BDA");
        
        Project project = new Project("IslandParadise", "Acquire a personal island paradise");
        Deliverable deliverable1 = new Deliverable("Island Paradise", "", contact1);
        Task task1 = new Task("Fortune", "Acquire a small fortune", contact4, 11.0);
        Task task2 = new Task("Isle", "Locate an island for sale", contact2, 7.5);
        Task task3 = new Task("Name", "Decide on a name for the island", contact3, 3.2);
        project.addProjectItem(deliverable1);
        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);
        
        Deliverable deliverable11 = new Deliverable("$1,000,000", "(total net worth after taxes)", contact1);
        Task task11 = new Task("Fortune1", "Use psychic hotline to predict winning lottery numbers", contact4, 2.5);
        Task task12 = new Task("Fortune2", "Invest winnings to ensure 50% annual interest", contact1, 14.0);
        task1.addProjectItem(task11);
        task1.addProjectItem(task12);
        task1.addProjectItem(deliverable11);
        
        Task task21 = new Task("Isle1", "Research whether climate is better in the Atlantic or Pacific", contact1, 1.8);
        Task task22 = new Task("Isle2", "Locate an island for auction on EBay", contact4, 5.0);
        Task task23 = new Task("Isle2a", "Negotiate for sale of the island", contact3, 17.5);
        task2.addProjectItem(task21);
        task2.addProjectItem(task22);
        task2.addProjectItem(task23);
        
        Deliverable deliverable31 = new Deliverable("Island Name", "", contact1);
        task3.addProjectItem(deliverable31);
        return project;
    }
    
    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}