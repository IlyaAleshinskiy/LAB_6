public class FoldConstants implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        // Число остается как есть
        return new Number(number.getValue());
    }


    //sacsca
    @Override
    public Expression transformBinaryOperation(BinaryOperation binop) {
        Expression left = binop.getLeft().transform(this);
        Expression right = binop.getRight().transform(this);

        // Проверяем, являются ли оба операнда числами
        if (left instanceof Number && right instanceof Number) {
            double leftVal = ((Number)left).getValue();
            double rightVal = ((Number)right).getValue();
            double result = 0;

            switch (binop.getOperation()) {
                case BinaryOperation.PLUS: result = leftVal + rightVal; break;
                case BinaryOperation.MINUS: result = leftVal - rightVal; break;
                case BinaryOperation.MUL: result = leftVal * rightVal; break;
                case BinaryOperation.DIV: result = leftVal / rightVal; break;
            }

            // Освобождаем память промежуточных узлов
            if (left != binop.getLeft()) ((Number)left).dispose();
            if (right != binop.getRight()) ((Number)right).dispose();

            return new Number(result);
        }

        // Если не оба числа, возвращаем новую операцию с преобразованными операндами
        return new BinaryOperation(left, binop.getOperation(), right);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall fcall) {
        Expression arg = fcall.getArgument().transform(this);

        // Если аргумент - число, пытаемся вычислить функцию
        if (arg instanceof Number) {
            double argVal = ((Number)arg).getValue();
            double result = 0;

            switch (fcall.getName()) {
                case "sqrt": result = Math.sqrt(argVal); break;
                case "abs": result = Math.abs(argVal); break;
                default:
                    // Неизвестная функция, возвращаем как есть
                    return new FunctionCall(fcall.getName(), arg);
            }

            // Освобождаем память промежуточного узла
            if (arg != fcall.getArgument()) ((Number)arg).dispose();

            return new Number(result);
        }

        // Если аргумент не число, возвращаем как есть
        return new FunctionCall(fcall.getName(), arg);
    }

    @Override
    public Expression transformVariable(Variable var) {
        // Переменная остается как есть
        return new Variable(var.getName());
    }
}