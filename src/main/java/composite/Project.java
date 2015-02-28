package composite;

import java.util.ArrayList;
import java.util.Iterator;
public class Project implements ProjectItem{
    private String name;
    private String description;
    private ArrayList projectItems = new ArrayList();
    
    public Project(){ }
    public Project(String newName, String newDescription){
        name = newName;
        description = newDescription;
    }    
    
    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public ArrayList getProjectItems(){ return projectItems; }
    public double getTimeRequired(){
        double totalTime = 0;
        Iterator items = projectItems.iterator();
        while(items.hasNext()){
            ProjectItem item = (ProjectItem)items.next();
            totalTime += item.getTimeRequired();
        }
        return totalTime;
    }
    
    public void setName(String newName){ name = newName; }
    public void setDescription(String newDescription){ description = newDescription; }
    
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
}