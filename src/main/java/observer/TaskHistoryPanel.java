package observer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class TaskHistoryPanel extends JPanel implements TaskChangeObserver{
    private JTextArea displayRegion;
    
    public TaskHistoryPanel(){
        createGui();
    }
    public void createGui(){
        setLayout(new BorderLayout());
        displayRegion = new JTextArea(10, 40);
        displayRegion.setEditable(false);
        add(new JScrollPane(displayRegion));
    }
    public void taskAdded(Task task){
        displayRegion.append("Created task " + task + "\n");
    }
    public void taskChanged(Task task){
        displayRegion.append("Updated task " + task + "\n");
    }
    public void taskSelected(Task task){
        displayRegion.append("Selected task " + task + "\n");
    }
}