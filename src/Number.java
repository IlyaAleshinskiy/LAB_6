public class Number extends Expression {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void dispose() {}

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformNumber(this);
    }
}
