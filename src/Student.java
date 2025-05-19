// Student.java
public class Student implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
