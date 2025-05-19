// Session.java
public class Session implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент сдает экзамены");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор принимает экзамены");
    }
}
