public class CopySyntaxTree implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        return new Number(number.getValue());
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binop) {
        Expression newLeft = binop.getLeft().transform(this);
        Expression newRight = binop.getRight().transform(this);
        return new BinaryOperation(newLeft, binop.getOperation(), newRight);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall fcall) {
        Expression newArg = fcall.getArgument().transform(this);
        return new FunctionCall(fcall.getName(), newArg);
    }

    @Override
    public Expression transformVariable(Variable var) {
        return new Variable(var.getName());
    }
}
