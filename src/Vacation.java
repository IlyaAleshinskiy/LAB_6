public class Vacation implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент отдыхает");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор уходит в отпуск");
    }

    @Override
    public void visit(Aspirant aspirant) {
        System.out.println("Аспирант отдыхает и работает над диссертацией");
    }
}