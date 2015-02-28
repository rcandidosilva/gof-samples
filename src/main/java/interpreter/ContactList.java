package interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
public class ContactList implements Serializable{
    private ArrayList contacts = new ArrayList();
    
    public ArrayList getContacts(){ return contacts; }
    public Contact [] getContactsAsArray(){ return (Contact [])(contacts.toArray(new Contact [1])); }
    
    public ArrayList getContactsMatchingExpression(Expression expr, Context ctx, Object key){
        ArrayList results = new ArrayList();
        Iterator elements = contacts.iterator();
        while (elements.hasNext()){
            Object currentElement = elements.next();
            ctx.addVariable(key, currentElement);
            expr.interpret(ctx);
            Object interpretResult = ctx.get(expr);
            if ((interpretResult != null) && (interpretResult.equals(Boolean.TRUE))){
                results.add(currentElement);
            }
        }
        return results;
    }
    
    public void setContacts(ArrayList newContacts){ contacts = newContacts; }
    
    public void addContact(Contact element){
        if (!contacts.contains(element)){
            contacts.add(element);
        }
    }
    public void removeContact(Contact element){
        contacts.remove(element);
    }
    
    public String toString(){
        return contacts.toString();
    }
}