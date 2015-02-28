package bridge;

public class RunPattern{
    public static void main(String [] arguments){
        System.out.println("Example for the Bridge pattern");
        System.out.println();
        System.out.println("This example divides complex behavior among two");
        System.out.println(" classes - the abstraction and the implementation.");
        System.out.println();
        System.out.println("In this case, there are two classes which can provide the");
        System.out.println(" abstraction - BaseList and OrnamentedList. The BaseList");
        System.out.println(" provides core funtionality, while the OrnamentedList");
        System.out.println(" expands on the model by adding a list character.");
        System.out.println();
        System.out.println("The OrderedListImpl class provides the underlying storage");
        System.out.println(" capability for the list, and can be flexibly paired with");
        System.out.println(" either of the classes which provide the abstraction.");
        
        System.out.println("Creating the OrderedListImpl object.");
        ListImpl implementation = new OrderedListImpl();
        
        System.out.println("Creating the BaseList object.");
        BaseList listOne = new BaseList();
        listOne.setImplementor(implementation);
        System.out.println();
        
        System.out.println("Adding elements to the list.");
        listOne.add("One");
        listOne.add("Two");
        listOne.add("Three");
        listOne.add("Four");
        System.out.println();
        
        System.out.println("Creating an OrnamentedList object.");
        OrnamentedList listTwo = new OrnamentedList();
        listTwo.setImplementor(implementation);
        listTwo.setItemType('+');
        System.out.println();
        
        System.out.println("Creating an NumberedList object.");
        NumberedList listThree = new NumberedList();
        listThree.setImplementor(implementation);
        System.out.println();
        
        System.out.println("Printing out first list (BaseList)");
        for (int i = 0; i < listOne.count(); i++){
            System.out.println("\t" + listOne.get(i));
        }
        System.out.println();
        
        System.out.println("Printing out second list (OrnamentedList)");
        for (int i = 0; i < listTwo.count(); i++){
            System.out.println("\t" + listTwo.get(i));
        }
        System.out.println();
        
        System.out.println("Printing our third list (NumberedList)");
        for (int i = 0; i < listThree.count(); i++){
            System.out.println("\t" + listThree.get(i));
        }
    }
}