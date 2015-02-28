package chain;

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
        
        Project project = new Project("IslandParadise", "Acquire a personal island paradise", contact2);
        
        Task task1 = new Task(project, "Fortune", "Acquire a small fortune", contact4, true);
        Task task2 = new Task(project, "Isle", "Locate an island for sale", null, true);
        Task task3 = new Task(project, "Name", "Decide on a name for the island", contact3, false);
        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);
        
        Task task4 = new Task(task1, "Fortune1", "Use psychic hotline to predict winning lottery numbers", null, false);
        Task task5 = new Task(task1, "Fortune2", "Invest winnings to ensure 50% annual interest", contact1, true);
        Task task6 = new Task(task2, "Isle1", "Research whether climate is better in the Atlantic or Pacific", contact1, true);
        Task task7 = new Task(task2, "Isle2", "Locate an island for auction on EBay", null, false);
        Task task8 = new Task(task2, "Isle2a", "Negotiate for sale of the island", null, false);
        Task task9 = new Task(task3, "Name1", "Research every possible name in the world", null, true);
        Task task10 = new Task(task3, "Name2", "Eliminate any choices that are not coffee-related", contact4, false);
        task1.addProjectItem(task4);
        task1.addProjectItem(task5);
        task2.addProjectItem(task6);
        task2.addProjectItem(task7);
        task2.addProjectItem(task8);
        task3.addProjectItem(task9);
        task3.addProjectItem(task10);
        return project;
    }
    
    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}