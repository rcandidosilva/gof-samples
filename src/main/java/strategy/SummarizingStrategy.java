package strategy;

public interface SummarizingStrategy{
    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String DELIMITER = ":";
    public static final String COMMA = ",";
    public static final String SPACE = " ";
    
    public String summarize(Contact [] contactList);
    public String [] makeSummarizedList(Contact [] contactList);
}