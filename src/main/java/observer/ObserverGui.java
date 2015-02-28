package observer;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
public class ObserverGui{
    public void createGui(){
        JFrame mainFrame = new JFrame("Observer Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        TaskChangeObservable observable = new TaskChangeObservable();
        TaskSelectorPanel select = new TaskSelectorPanel(observable);
        TaskHistoryPanel history = new TaskHistoryPanel();
        TaskEditorPanel edit = new TaskEditorPanel(observable);
        observable.addTaskChangeObserver(select);
        observable.addTaskChangeObserver(history);
        observable.addTaskChangeObserver(edit);
        observable.addTask(new Task());
        content.add(select);
        content.add(history);
        content.add(edit);
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent evt){
            System.exit(0);
        }
    }
}