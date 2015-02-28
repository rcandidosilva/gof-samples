package factorymethod;

import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Contact implements Editable, Serializable {
    private String name;
    private String relationship;

    public ItemEditor getEditor() {
        return new ContactEditor();
    }
    
    private class ContactEditor implements ItemEditor, Serializable {
        private transient JPanel panel;
        private transient JTextField nameField;
        private transient JTextField relationField;
        
        public JComponent getGUI() {
            if (panel == null) {
                panel = new JPanel();
                nameField = new JTextField(name);
                relationField = new JTextField(relationship);
                panel.setLayout(new GridLayout(2,2));
                panel.add(new JLabel("Name:"));
                panel.add(nameField);
                panel.add(new JLabel("Relationship:"));
                panel.add(relationField);
            } else {
                nameField.setText(name);
                relationField.setText(relationship);
            }
            return panel;
        }
        
        public void commitChanges() {
            if (panel != null) {
                name = nameField.getText();
                relationship = relationField.getText();
            }
        }
        
        public String toString(){
            return "\nContact:\n" +
                "    Name: " + name + "\n" +
                "    Relationship: " + relationship;
        }
    }
}