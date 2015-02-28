package interpreter;

import java.util.HashMap;
public class Context{
    private HashMap map = new HashMap();
    
    public Object get(Object name){
        return map.get(name);
    }
    
    public void addVariable(Object name, Object value){
        map.put(name, value);
    }
}