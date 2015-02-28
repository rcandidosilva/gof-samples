package iterator;

import java.util.Iterator;
import java.io.PrintStream;
public class ListPrinter{
    public static void printToDoList(ToDoList list, PrintStream output){
        Iterator elements = list.getIterator();
        output.println("  List - " + list + ":");
        while (elements.hasNext()){
            output.println("\t" + elements.next());
        }
    }
    
    public static void printToDoListCollection(ToDoListCollection lotsOfLists, PrintStream output){
        Iterator elements = lotsOfLists.getIterator();
        output.println("\"To Do\" List Collection:");
        while (elements.hasNext()){
            printToDoList((ToDoList)elements.next(), output);
        }
    }
    
    public static void printIteratingElement(Iterating element, PrintStream output){
        output.println("Printing the element " + element);
        Iterator elements = element.getIterator();
        while (elements.hasNext()){
            Object currentElement = elements.next();
            if (currentElement instanceof Iterating){
                printIteratingElement((Iterating)currentElement, output);
                output.println();
            }
            else{
                output.println(currentElement);
            }
        }
    }
}