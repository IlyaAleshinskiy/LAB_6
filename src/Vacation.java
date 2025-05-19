// Vacation.java
public class Vacation implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент отдыхает");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор уходит в отпуск");
    }
}
