package factorymethod;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class EditorGui implements ActionListener{
    private JFrame mainFrame;
    private JTextArea display;
    private JButton update, exit;
    private JPanel controlPanel, displayPanel, editorPanel;
    private ItemEditor editor;
    
    public EditorGui(ItemEditor edit){
        editor = edit;
    }
    
    public void createGui(){
        mainFrame = new JFrame("Factory Pattern Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        editorPanel = new JPanel();
        editorPanel.add(editor.getGUI());
        content.add(editorPanel);
        
        displayPanel = new JPanel();
        display = new JTextArea(10, 40);
        display.setEditable(false);
        displayPanel.add(display);
        content.add(displayPanel);
        
        controlPanel = new JPanel();
        update = new JButton("Update Item");
        exit = new JButton("Exit");
        controlPanel.add(update);
        controlPanel.add(exit);
        content.add(controlPanel);
        
        update.addActionListener(this);
        exit.addActionListener(this);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent evt){
        Object originator = evt.getSource();
        if (originator == update){
            updateItem();
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
    
    private void updateItem(){
        editor.commitChanges();
        display.setText(editor.toString());
    }
    
    private void exitApplication(){
        System.exit(0);
    }
}