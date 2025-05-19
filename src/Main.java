public class Main {
    public static void main(String[] args) {
        Number n32 = new Number(32.0);
        Number n16 = new Number(16.0);

        BinaryOperation minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        FunctionCall callSqrt = new FunctionCall("sqrt", minus);

        Variable var = new Variable("var");
        BinaryOperation mult = new BinaryOperation(var, BinaryOperation.MUL, callSqrt);

        FunctionCall callAbs = new FunctionCall("abs", mult);

        FoldConstants FC = new FoldConstants();
        Expression newExpr = callAbs.transform(FC);

        // Выводим результаты
        System.out.println("Original expression:");
        printExpression(callAbs, 0);

        System.out.println("\nAfter constant folding:");
        printExpression(newExpr, 0);
    }

    private static void printExpression(Expression expr, int indent) {
        for (int i = 0; i < indent; i++) System.out.print("  ");

        if (expr instanceof Number) {
            System.out.println("Number: " + ((Number)expr).getValue());
        }
        else if (expr instanceof BinaryOperation) {
            BinaryOperation binop = (BinaryOperation)expr;
            System.out.println("BinaryOp: " + binop.getOperation());
            printExpression(binop.getLeft(), indent + 1);
            printExpression(binop.getRight(), indent + 1);
        }
        else if (expr instanceof FunctionCall) {
            FunctionCall fcall = (FunctionCall)expr;
            System.out.println("FunctionCall: " + fcall.getName());
            printExpression(fcall.getArgument(), indent + 1);
        }
        else if (expr instanceof Variable) {
            System.out.println("Variable: " + ((Variable)expr).getName());
        }
    }
}