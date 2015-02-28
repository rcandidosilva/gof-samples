package chain;

import java.io.Serializable;
import java.util.ArrayList;
public interface ProjectItem extends Serializable{
    public static final String EOL_STRING = System.getProperty("line.separator");
    public ProjectItem getParent();
    public Contact getOwner();
    public String getDetails();
    public ArrayList getProjectItems();
}