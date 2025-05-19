// FunctionCall.java
public class FunctionCall extends Expression {
    private final String name;
    private final Expression argument;

    public FunctionCall(String name, Expression argument) {
        this.name = name;
        this.argument = argument;
    }

    public String getName() {
        return name;
    }

    public Expression getArgument() {
        return argument;
    }

    @Override
    public double evaluate() {
        // В реальной реализации здесь было бы вычисление функции
        throw new UnsupportedOperationException();
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformFunctionCall(this);
    }
}
