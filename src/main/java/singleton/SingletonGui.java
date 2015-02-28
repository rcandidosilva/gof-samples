package singleton;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SingletonGui implements ActionListener{
    private JFrame mainFrame;
    private JTextArea display;
    private JButton newContact, newAppointment, undo, refresh, exit;
    private JPanel controlPanel, displayPanel;
    private static int historyCount;
    
    public void createGui(){
        mainFrame = new JFrame("Singleton Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        displayPanel = new JPanel();
        display = new JTextArea(20, 60);
        display.setEditable(false);
        displayPanel.add(display);
        content.add(displayPanel);
        
        controlPanel = new JPanel();
        newContact = new JButton("Create contact");
        newAppointment = new JButton("Create appointment");
        undo = new JButton("Undo");
        refresh = new JButton("Refresh");
        exit = new JButton("Exit");
        controlPanel.add(newContact);
        controlPanel.add(newAppointment);
        controlPanel.add(undo);
        controlPanel.add(refresh);
        controlPanel.add(exit);
        content.add(controlPanel);
        
        newContact.addActionListener(this);
        newAppointment.addActionListener(this);
        undo.addActionListener(this);
        refresh.addActionListener(this);
        exit.addActionListener(this);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public void refreshDisplay(String actionMessage){
        display.setText(actionMessage + "\nCOMMAND HISTORY:\n" +
            HistoryList.getInstance().toString());
    }
    
    public void actionPerformed(ActionEvent evt){
        Object originator = evt.getSource();
        if (originator == newContact){
            addCommand(" New Contact");
        }
        else if (originator == newAppointment){
            addCommand(" New Appointment");
        }
        else if (originator == undo){
            undoCommand();
        }
        else if (originator == refresh){
            refreshDisplay("");
        }
        else if (originator == exit){
            exitApplication();
        }
    }
    
    private class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent evt){
            exitApplication();
        }
    }
    
    private void addCommand(String message){
        HistoryList.getInstance().addCommand((++historyCount) + message);
        refreshDisplay("Add Command: " + message);
    }
    
    private void undoCommand(){
        Object result = HistoryList.getInstance().undoCommand();
        historyCount--;
        refreshDisplay("Undo Command: " + result);
    }
    
    private void exitApplication(){
        System.exit(0);
    }
}