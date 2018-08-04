import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * Main function, iterates through all files and calculate them
     * @param args filenames
     */
    public static void main(String[] args) {
        for (String filename : args) {
            System.out.println(doCalculation(filename));
        }
    }

    /**
     * Parse file lines and calculate the result
     * @param filename
     * @return calculation result
     */
    static Integer doCalculation(String filename) {
        List<String> linesList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String lastLine = linesList.get(linesList.size() - 1);
        String[] opVal = lastLine.split(" ");

        Integer result = doOperation(new Integer(opVal[1]),
                Operators.APPLY, null);//OP should be APPLY

        for (String line : linesList) {
            opVal = line.split(" ");
            result = doOperation(result,
                    getEnum(opVal[0]), new Integer(opVal[1]));
        }
        return result;
    }

    /**
     * Do a single operation using the two values
     * @param base
     * @param op
     * @param val
     * @return operation result
     */
    static Integer doOperation(Integer base, Operators op, Integer val) {
        switch (op) {
            case ADD:
                return base + val;
            case SUBTRACT:
                return base - val;
            case DIVIDE:
                return base / val;
            case MULTIPLY:
                return base * val;
            case APPLY:
                return base;
            default:
                return base;
        }
    }

    /**
     * Get operation enum from string
     * @param op
     * @return Operation enum
     */
    static Operators getEnum(String op) {
        switch (op.toUpperCase()) {
            case "ADD":
                return Operators.ADD;
            case "SUBTRACT":
                return Operators.SUBTRACT;
            case "MULTIPLY":
                return Operators.MULTIPLY;
            case "DIVIDE":
                return Operators.DIVIDE;
            case "APPLY":
                return Operators.APPLY;
            default:
                return null;
        }
    }

    enum Operators {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, APPLY
    }

}


