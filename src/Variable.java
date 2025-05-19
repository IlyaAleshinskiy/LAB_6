// Variable.java
public class Variable extends Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double evaluate() {
        // В реальной реализации здесь было бы получение значения переменной
        throw new UnsupportedOperationException();
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformVariable(this);
    }
}
