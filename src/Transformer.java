// Transformer.java
public interface Transformer {
    Expression transformNumber(Number number);
    Expression transformBinaryOperation(BinaryOperation binop);
    Expression transformFunctionCall(FunctionCall fcall);
    Expression transformVariable(Variable var);
}
