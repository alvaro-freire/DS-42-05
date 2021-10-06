package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {
    float result;
    List<String> Operations = new ArrayList<>();
    List<String> InternalState = new ArrayList<>();
    List<Float> Operators = new ArrayList<>();

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

        /* Check if operation does not exist: */
        if (!Objects.equals(operation, "+") &&
                !Objects.equals(operation, "-") &&
                !Objects.equals(operation, "*") &&
                !Objects.equals(operation, "/")) {
            throw new IllegalArgumentException();
        }
        Operations.add(operation);

        for (Float value : values) {
            Operators.add(value);
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
        String string;

        switch (Operations.get(0)) {
            case "+" -> result = Operators.get(0) + Operators.get(1);
            case "-" -> result = Operators.get(0) - Operators.get(1);
            case "*" -> result = Operators.get(0) * Operators.get(1);
            case "/" -> {
                if (Operators.get(1) == 0) {
                    throw new ArithmeticException();
                }
                result = Operators.get(0) / Operators.get(1);
            }
        }
        string = "[" + Operations.get(0) + "]";

        for (int i = 1; i < Operations.size(); i++) {
            switch (Operations.get(i)) {
                case "+" -> result += Operators.get(i + 1);
                case "-" -> result -= Operators.get(i + 1);
                case "*" -> result *= Operators.get(i + 1);
                case "/" -> {
                    if (Operators.get(1) == 0) {
                        throw new ArithmeticException();
                    }
                    result /= Operators.get(i + 1);
                }
            }
            string = string.concat("_" + Operators.get(i).toString());
        }

        InternalState.add(string);

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

        return string;
    }
}
