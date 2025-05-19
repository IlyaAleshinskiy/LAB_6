public interface Visitor {
    void visit(Student student);
    void visit(Professor professor);
    void visit(Aspirant aspirant);
}