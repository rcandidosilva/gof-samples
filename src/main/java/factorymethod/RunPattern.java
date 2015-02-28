package factorymethod;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class RunPattern{
    public static void main(String [] arguments){
        System.out.println("Example for the FactoryMethod pattern");
        System.out.println();
        
        System.out.println("Creating a Contact object");
        System.out.println();
        Contact someone = new Contact();
        
        System.out.println("Creating a GUI editor for the Contact");
        System.out.println();
        System.out.println("The GUI defined in the EditorGui class is a truly generic editor.");
        System.out.println("It accepts an argument of type ItemEditor, and delegates");
        System.out.println(" all editing tasks to its ItemEditor and the associated GUI.");
        System.out.println(" The getEditor() Factory Method is used to obtain the ItemEditor");
        System.out.println(" for the example.");
        System.out.println();
        System.out.println("Notice that the editor in the top portion of the GUI is,");
        System.out.println(" in fact, returned by the ItemEditor belonging to the");
        System.out.println(" Contact class, and has appropriate fields for that class.");
        
        EditorGui runner = new EditorGui(someone.getEditor());
        runner.createGui();
    }
}