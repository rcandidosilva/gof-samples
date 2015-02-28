package interpreter;

public class ContainsExpression extends ComparisonExpression{
    public ContainsExpression(Expression expressionA, Expression expressionB){
        super(expressionA, expressionB);
    }

    public void interpret(Context c){
        expressionA.interpret(c);
        expressionB.interpret(c);
        Object exprAResult = c.get(expressionA);
        Object exprBResult = c.get(expressionB);
        if ((exprAResult instanceof String) && (exprBResult instanceof String)){
            if (((String)exprAResult).indexOf((String)exprBResult) != -1){
                c.addVariable(this, Boolean.TRUE);
                return;
            }
        }
        c.addVariable(this, Boolean.FALSE);
        return;
    }
}