// Model
public class Contact{
    private String firstName;
    private String lastName;
    private String title;
    private String organization;
    
    private ContactView view;
    
    public Contact(ContactView v){
        
        firstName = "";
        lastName = "";
        title = "";
        organization = "";
        
        view = v;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getOrganization(){
        return organization;
    }
    
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    
    public void setTitle(String newTitle){
        title = newTitle;
    }
    
    public void setOrganization(String newOrganization){
        organization = newOrganization;
    }
    
    public void updateModel(String newFirstName,
        String newLastName, String newTitle,
        String newOrganization){
        
        if ((newFirstName != null) && !newFirstName.equals("")){
            setFirstName(newFirstName);
        }
        
        if ((newLastName != null) && !newLastName.equals("")){
            setLastName(newLastName);
        }
        
        if ((newTitle != null) && !newTitle.equals("")){
            setTitle(newTitle);
        }
        
        if ((newOrganization != null) && !newOrganization.equals("")){
            setOrganization(newOrganization);
        }
        
        updateView();
    }
    
    private void updateView(){
        view.refreshContactView(firstName, lastName, title, organization);
    }
}

