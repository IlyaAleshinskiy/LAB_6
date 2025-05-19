public class Aspirant implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
