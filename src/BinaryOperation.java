// BinaryOperation.java
public class BinaryOperation extends Expression {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char DIV = '/';
    public static final char MUL = '*';

    private final Expression left;
    private final char operation;
    private final Expression right;

    public BinaryOperation(Expression left, char operation, Expression right) {
        this.left = left;
        this.operation = operation;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public char getOperation() {
        return operation;
    }

    @Override
    public double evaluate() {
        switch (operation) {
            case PLUS: return left.evaluate() + right.evaluate();
            case MINUS: return left.evaluate() - right.evaluate();
            case MUL: return left.evaluate() * right.evaluate();
            case DIV: return left.evaluate() / right.evaluate();
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformBinaryOperation(this);
    }
}
