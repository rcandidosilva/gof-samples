package observer;

import java.util.ArrayList;
import java.util.Iterator;
public class TaskChangeObservable{
    private ArrayList observers = new ArrayList();
    
    public void addTaskChangeObserver(TaskChangeObserver observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }
    public void removeTaskChangeObserver(TaskChangeObserver observer){
        observers.remove(observer);
    }
    
    public void selectTask(Task task){
        Iterator elements = observers.iterator();
        while (elements.hasNext()){
            ((TaskChangeObserver)elements.next()).taskSelected(task);
        }
    }
    public void addTask(Task task){
        Iterator elements = observers.iterator();
        while (elements.hasNext()){
            ((TaskChangeObserver)elements.next()).taskAdded(task);
        }
    }
    public void updateTask(Task task){
        Iterator elements = observers.iterator();
        while (elements.hasNext()){
            ((TaskChangeObserver)elements.next()).taskChanged(task);
        }
    }
}