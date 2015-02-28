package interpreter;

public class EqualsExpression extends ComparisonExpression{
    public EqualsExpression(Expression expressionA, Expression expressionB){
        super(expressionA, expressionB);
    }

    public void interpret(Context c){
        expressionA.interpret(c);
        expressionB.interpret(c);
        Boolean result = new Boolean(c.get(expressionA).equals(c.get(expressionB)));
        c.addVariable(this, result);
    }
}