public class Main {
    public static void main(String[] args) {
        Number n32 = new Number(32.0);
        Number n16 = new Number(16.0);

        BinaryOperation minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        FunctionCall callSqrt = new FunctionCall("sqrt", minus);

        Variable var = new Variable("var");
        BinaryOperation mult = new BinaryOperation(var, BinaryOperation.MUL, callSqrt);

        FunctionCall callAbs = new FunctionCall("abs", mult);

        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = callAbs.transform(CST);

        // Проверка, что это действительно копия (а не те же объекты)
        System.out.println("Original and copy are different objects: " + (callAbs != newExpr));

        // Проверка структуры копии
        FunctionCall copiedCallAbs = (FunctionCall) newExpr;
        BinaryOperation copiedMult = (BinaryOperation) copiedCallAbs.getArgument();

        System.out.println("Structure is preserved:");
        System.out.println("Top function: " + copiedCallAbs.getName());
        System.out.println("Operation: " + copiedMult.getOperation());
    }
}
