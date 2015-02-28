package strategy;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
public class OrganizationSummarizer implements SummarizingStrategy{
    private Comparator comparator = new OrganizationComparator();
    
    public String summarize(Contact [] contactList){
        StringBuffer product = new StringBuffer();
        Arrays.sort(contactList, comparator);
        for (int i = 0; i < contactList.length; i++){
            product.append(contactList[i].getOrganization());
            product.append(DELIMITER);
            product.append(SPACE);
            product.append(contactList[i].getFirstName());
            product.append(SPACE);
            product.append(contactList[i].getLastName());
            product.append(EOL_STRING);
        }
        return product.toString();
    }
    
    public String [] makeSummarizedList(Contact [] contactList){
        Arrays.sort(contactList, comparator);
        String [] product = new String[contactList.length];
        for (int i = 0; i < contactList.length; i++){
            product[i] = contactList[i].getOrganization() + DELIMITER + SPACE +
                         contactList[i].getFirstName() + SPACE +
                         contactList[i].getLastName() + EOL_STRING;
        }
        return product;
    }
    
    private class OrganizationComparator implements Comparator{
        private Collator textComparator = Collator.getInstance();
        
        public int compare(Object o1, Object o2){
            Contact c1, c2;
            if ((o1 instanceof Contact) && (o2 instanceof Contact)){
                c1 = (Contact)o1;
                c2 = (Contact)o2;
                int compareResult = textComparator.compare(c1.getOrganization(), c2.getOrganization());
                if (compareResult == 0){
                    compareResult = textComparator.compare(c1.getLastName(), c2.getLastName());
                }
                return compareResult;
            }
            else return textComparator.compare(o1, o2);
        }
        
        public boolean equals(Object o){
            return textComparator.equals(o);
        }
    }
}