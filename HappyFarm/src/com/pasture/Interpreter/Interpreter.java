package com.pasture.Interpreter;

public class Interpreter {
    public static Expression getLivestockExpression(){
        Expression sheep = new TerminalExpression("Sheep");
        Expression chicken = new TerminalExpression("Chicken");
        return new OrExpression(sheep, chicken);
    }

    public static Expression getAllLivestockExpression(){
        Expression sheep = new TerminalExpression("Sheep");
        Expression chicken = new TerminalExpression("Chicken");
        return new AndExpression(chicken, sheep);
    }
}
