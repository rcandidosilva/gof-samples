package interpreter;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
public class VariableExpression implements Expression{
    private Object lookup;
    private String methodName;
    
    public VariableExpression(Object newLookup, String newMethodName){
        lookup = newLookup;
        methodName = newMethodName;
    }
    
    public void interpret(Context c){
        try{
            Object source = c.get(lookup);
            if (source != null){
                Method method = source.getClass().getMethod(methodName, null);
                Object result = method.invoke(source, null);
                c.addVariable(this, result);
            }
        }
        catch (NoSuchMethodException exc){ }
        catch (IllegalAccessException exc){ }
        catch (InvocationTargetException exc){ }
    }
}