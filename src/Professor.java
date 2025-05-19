// Professor.java
public class Professor implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
