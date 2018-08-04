import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {

    private static final Logger log = Logger.getLogger(MainTest.class.getName());

    @Test
    void testDoOperations(){
        assertEquals(new Integer(5),
                Main.doOperation(2, Main.Operators.ADD, 3));

        assertEquals(new Integer(2),
                Main.doOperation(12, Main.Operators.SUBTRACT, 10));

        assertEquals(new Integer(10),
                Main.doOperation(100, Main.Operators.DIVIDE, 10));

        assertEquals(new Integer(42),
                Main.doOperation(42, Main.Operators.APPLY, 12345));
    }

    @Test
    void testGetEnum(){
        Main.Operators op = Main.getEnum("add");
        assertEquals(Main.Operators.ADD, op);

        op = Main.getEnum("subtract");
        assertEquals(Main.Operators.SUBTRACT, op);

        op = Main.getEnum("diVIde");
        assertEquals(Main.Operators.DIVIDE, op);

        op = Main.getEnum("APPLY");
        assertEquals(Main.Operators.APPLY, op);

        op = Main.getEnum("ssttrriinngg");
        assertNull(op);

    }

    @Test
    void testDoCalculation(){
        assertEquals(Main.doCalculation("file.txt"), new Integer(18));
        assertEquals(Main.doCalculation("file2.txt"), new Integer(2));
        assertEquals(Main.doCalculation("file3.txt"), new Integer(-6));
        assertEquals(Main.doCalculation("file4.txt"), new Integer(0));
    }
}
