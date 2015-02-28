package strategy;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataCreator{
    private static final String DEFAULT_FILE = "data.ser";
    
    public static void main(String [] args){
        String fileName;
        if (args.length == 1){
            fileName = args[0];
        }
        else{
            fileName = DEFAULT_FILE;
        }
        serialize(fileName);
    }
    
    public static void serialize(String fileName){
        try{
            serializeToFile(makeContactList(), fileName);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
    
    private static Serializable makeContactList(){
        ContactList list = new ContactList();
        list.addContact(new ContactImpl("David", "St. Hubbins", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Mick", "Shrimpton", "Drummer", "The New Originals"));
        list.addContact(new ContactImpl("Nigel", "Tufnel", "Lead Guitar", "The New Originals"));
        list.addContact(new ContactImpl("Derek", "Smalls", "Bass", "The New Originals"));
        list.addContact(new ContactImpl("Viv", "Savage", "Keyboards", "The New Originals"));
        list.addContact(new ContactImpl("Nick", "Shrimpton", "CEO", "Fishy Business, LTD"));
        list.addContact(new ContactImpl("Nickolai", "Lobachevski", "Senior Packer", "Fishy Business, LTD"));
        list.addContact(new ContactImpl("Alan", "Robertson", "Comptroller", "Universal Exports"));
        list.addContact(new ContactImpl("William", "Telle", "President", "Universal Exports"));
        list.addContact(new ContactImpl("Harvey", "Manfredjensenden", "Inspector", "Universal Imports"));
        list.addContact(new ContactImpl("Deirdre", "Pine", "Chief Mechanic", "The Universal Joint"));
        list.addContact(new ContactImpl("Martha", "Crump-Pinnett", "Lead Developer", "Avatar Inc."));
        list.addContact(new ContactImpl("Bryan", "Basham", "CTO", "IOVA"));
        return list;
    }
    
    private static void serializeToFile(Serializable content, String fileName) throws IOException{
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}