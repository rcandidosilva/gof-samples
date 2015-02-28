package interpreter;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
public class ConstantExpression implements Expression{
    private Object value;
    
    public ConstantExpression(Object newValue){
        value = newValue;
    }
    
    public void interpret(Context c){
        c.addVariable(this, value);
    }
}