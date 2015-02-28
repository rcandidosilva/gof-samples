package flyweight;

public class RunPattern{
    public static void main(String [] arguments) throws java.io.IOException{
        System.out.println("Example for the Flyweight pattern");
        System.out.println();
        System.out.println("In this sample, State objects are shared between multiple");
        System.out.println(" parts of the PIM. Two lists, representing a Contact list");
        System.out.println(" and an Address Book, are used for the demonstration.");
        System.out.println(" The State objects - CleanState and DirtyState - represent");
        System.out.println(" the Flyweight objects in this example.");
        System.out.println();
        
        System.out.println("Creating ManagedList objects to hold Contacts and Addresses");
        ManagedList contactList = new ManagedList(Contact.class);
        ManagedList addressList = new ManagedList(Address.class);
        System.out.println();
        
        System.out.println("Printing the State for the application");
        printPIMState();
        System.out.println();
        
        System.out.println("Editing the Address and Contact lists");
        StateFactory.getCurrentState().edit(State.CONTACTS);
        StateFactory.getCurrentState().edit(State.ADDRESSES);
        contactList.addItem(new ContactImpl("f", "l", "t", "o"));
        addressList.addItem(new AddressImpl("d", "s", "c", "st", "z"));
        System.out.println("Printing the State for the application");
        printPIMState();
        System.out.println();
        
        System.out.println("Saving the Contact list");
        StateFactory.getCurrentState().save(new java.io.File("contacts.ser"), contactList.getItems(), State.CONTACTS);
        System.out.println("Printing the State for the application");
        printPIMState();
        System.out.println();
        
        System.out.println("Saving the Address list");
        StateFactory.getCurrentState().save(new java.io.File("addresses.ser"), addressList.getItems(), State.ADDRESSES);
        System.out.println("Printing the State for the application");
        printPIMState();
    }
    
    private static void printPIMState(){
        System.out.println("  Current State of the PIM: " + StateFactory.getCurrentState().getClass());
        System.out.println("  Object ID: " + StateFactory.getCurrentState().hashCode());
        System.out.println();
    }
}