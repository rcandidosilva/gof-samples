package chain;

import java.util.ArrayList;
public class Project implements ProjectItem{
    private String name;
    private Contact owner;
    private String details;
    private ArrayList projectItems = new ArrayList();
    
    public Project(){ }
    public Project(String newName, String newDetails, Contact newOwner){
        name = newName;
        owner = newOwner;
        details = newDetails;
    }
    
    public String getName(){ return name; }
    public String getDetails(){ return details; }
    public Contact getOwner(){ return owner; }
    public ProjectItem getParent(){ return null; }
    public ArrayList getProjectItems(){ return projectItems; }
    
    public void setName(String newName){ name = newName; }
    public void setOwner(Contact newOwner){ owner = newOwner; }
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