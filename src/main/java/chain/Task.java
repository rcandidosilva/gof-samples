package chain;

import java.util.ArrayList;
import java.util.ListIterator;
public class Task implements ProjectItem{
    private String name;
    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private String details;
    private ProjectItem parent;
    private boolean primaryTask;
    
    public Task(ProjectItem newParent){
        this(newParent, "", "", null, false);
    }
    public Task(ProjectItem newParent, String newName,
        String newDetails, Contact newOwner, boolean newPrimaryTask){
            parent = newParent;
            name = newName;
            owner = newOwner;
            details = newDetails;
            primaryTask = newPrimaryTask;
    }
    
    public Contact getOwner(){
        if (owner == null){
            return parent.getOwner();
        }
        else{
            return owner;
        }
    }
    
    public String getDetails(){
        if (primaryTask){
            return details;
        }
        else{
            return parent.getDetails() + EOL_STRING + "\t" + details;
        }
    }
    
    public String getName(){ return name; }
    public ArrayList getProjectItems(){ return projectItems; }
    public ProjectItem getParent(){ return parent; }
    public boolean isPrimaryTask(){ return primaryTask; }
    
    public void setName(String newName){ name = newName; }
    public void setOwner(Contact newOwner){ owner = newOwner; }
    public void setParent(ProjectItem newParent){ parent = newParent; }
    public void setPrimaryTask(boolean newPrimaryTask){ primaryTask = newPrimaryTask; }
    public void setDetails(String newDetails){ details = newDetails; }
    
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
    
    public String toString(){
        return name;
    }
}