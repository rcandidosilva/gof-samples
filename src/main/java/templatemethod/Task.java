package templatemethod;

import java.util.ArrayList;
import java.util.Iterator;
public class Task extends ProjectItem{
    private ArrayList projectItems = new ArrayList();
    private double taskTimeRequired;
    
    public Task(){ }
    public Task(String newName, String newDescription,
        double newTaskTimeRequired, double newRate){
        super(newName, newDescription, newRate);
        taskTimeRequired = newTaskTimeRequired;
    }
    
    public void setTaskTimeRequired(double newTaskTimeRequired){ taskTimeRequired = newTaskTimeRequired; }
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
    
    public double getTaskTimeRequired(){ return taskTimeRequired; }
    public Iterator getProjectItemIterator(){ return projectItems.iterator(); }
    public double getMaterialsCost(){
        double totalCost = 0;
        Iterator items = getProjectItemIterator();
        while (items.hasNext()){
            totalCost += ((ProjectItem)items.next()).getMaterialsCost();
        }
        return totalCost;
    }
    public double getTimeRequired(){
        double totalTime = taskTimeRequired;
        Iterator items = getProjectItemIterator();
        while (items.hasNext()){
            totalTime += ((ProjectItem)items.next()).getTimeRequired();
        }
        return totalTime;
    }
}