package RPNCalculator.src.test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import RPNCalculator.src.main.java.com.example.Main;

public class MainTest {

    @Test
    public void testMain() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run Main.main() with test expressions
        Main.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        // Verify the output produced by Main.main()
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("4 2 * = 8.0"));
        assertTrue(consoleOutput.contains("4 2 + 3 - = 3.0"));
        assertTrue(consoleOutput.contains("3 5 8 * 7 + * = 141.0"));
        assertTrue(consoleOutput.contains("4 2 - = 2.0"));
        assertTrue(consoleOutput.contains("3 5 8 * 7 - * = 99.0"));
    }
}
