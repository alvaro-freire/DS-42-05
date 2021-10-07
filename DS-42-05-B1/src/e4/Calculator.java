package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {

    /*
     * Class containing the four operations
     * available for the calculator
     */
    public enum Operator {
        ADD ("+"),
        SUB ("-"),
        MUL ("*"),
        DIV ("/");

        /* field type const */
        private final String op; /* string of the operation */

        /*
         * Constructor of enum operator
         */
        Operator(String op) {
            this.op = op;
        }

        /* Method of enum class */
        public String getOp() { return op; }
    }

    float result;
    List<String> Operations = new ArrayList<>();
    List<Float> Operators = new ArrayList<>();
    List<String> InternalState = new ArrayList<>();

    /**
     * Public constructor of the calculator .
     */
    public Calculator() {
    }

    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations() {
        Operators.clear();
        Operations.clear();
        InternalState.clear();
        result = 0;
    }

    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values    Operands of the new operation ( one or two operands ).
     *                  Uses the varargs feature .
     *                  https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation(String operation, float... values) {
        String string;
        int nValues = values.length;
        int count = 1;
        int OperationSize = Operations.size();
        int OperatorSize = Operators.size();
        boolean wasEmptyList = Operators.isEmpty();

        /* Check if operation does not exist: */
        if (!Objects.equals(operation, Operator.ADD.getOp()) &&
                !Objects.equals(operation, Operator.SUB.getOp()) &&
                !Objects.equals(operation, Operator.MUL.getOp()) &&
                !Objects.equals(operation, Operator.DIV.getOp())) {
            throw new IllegalArgumentException();
        }
        Operations.add(operation);

        string = "[" + Operations.get(OperationSize) + "]";

        for (Float value : values) {
            /* Check if two values were introduced
             * and it was not the first operation: */
            if (!wasEmptyList && nValues == 2) {
                Operators.add(value);
                string = string.concat(value.toString());
                break;
            }
            Operators.add(value);
            if (nValues == 2 && count == 1) {
                string = string.concat(value.toString() + "_");
            } else {
                string = string.concat(value.toString());
            }
            count++;
        }

        if (nValues == 2) {
            if (Objects.equals(Operations.get(OperationSize), Operator.DIV.getOp())) {
                if (Operators.get(OperatorSize + 1) != 0) {
                    InternalState.add(string);
                }
            } else {
                InternalState.add(string);
            }
        } else {
            if (Objects.equals(Operations.get(OperationSize), Operator.DIV.getOp())) {
                if (Operators.get(OperatorSize) != 0) {
                    InternalState.add(string);
                }
            } else {
                InternalState.add(string);
            }
        }

    }

    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     *
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     *                             ( division by zero )
     */
    public float executeOperations() {

        switch (Operations.get(0)) {
            case "+" -> result = Operators.get(0) + Operators.get(1);
            case "-" -> result = Operators.get(0) - Operators.get(1);
            case "*" -> result = Operators.get(0) * Operators.get(1);
            case "/" -> {
                if (Operators.get(1) == 0) {
                    Operators.clear();
                    Operations.clear();
                    throw new ArithmeticException();
                }
                result = Operators.get(0) / Operators.get(1);
            }
        }

        for (int i = 1; i < Operations.size(); i++) {
            switch (Operations.get(i)) {
                case "+" -> result += Operators.get(i + 1);
                case "-" -> result -= Operators.get(i + 1);
                case "*" -> result *= Operators.get(i + 1);
                case "/" -> {
                    if (Operators.get(i + 1) == 0) {
                        throw new ArithmeticException();
                    }
                    result /= Operators.get(i + 1);
                }
            }
        }

        Operators.clear();
        Operations.clear();

        return result;
    }

    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/-/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     *
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString() {
        String string = "[STATE:";

        for (String s : InternalState) {
            string = string.concat(s);
        }

        string = string.concat("]");

        InternalState.clear();

        return string;
    }
}
