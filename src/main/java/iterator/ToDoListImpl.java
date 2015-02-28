package iterator;

import java.util.Iterator;
import java.util.ArrayList;
public class ToDoListImpl implements ToDoList{
    private String listName;
    private ArrayList items = new ArrayList();
    
    public void add(String item){
        if (!items.contains(item)){
            items.add(item);
        }
    }
    public void add(String item, int position){
        if (!items.contains(item)){
            items.add(position, item);
        }
    }
    public void remove(String item){
        if (items.contains(item)){
            items.remove(items.indexOf(item));
        }
    }
    
    public int getNumberOfItems(){ return items.size(); }
    public Iterator getIterator(){ return items.iterator(); }
    public String getListName(){ return listName; }
    public void setListName(String newListName){ listName = newListName; }
    
    public String toString(){ return listName; }
}