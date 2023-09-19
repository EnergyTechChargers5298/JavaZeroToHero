import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.Callable;

import org.junit.Test;

import pset.Problem_1;

public class CodeTester {

    private enum RESULT {
        PASSED("\u001B[32mPASSED\033[0m"), 
        FAILED("\u001B[31mFAILED\033[0m");

        private String formattedString;

        private RESULT(String formattedString) {
            this.formattedString = formattedString;
        }

        @Override
        public String toString() {
            return formattedString;
        }

        public static void success() {
            System.out.println(RESULT.PASSED);
        }

        public static void mismatch(String expected, String actual) {
            System.out.println(RESULT.FAILED);
            System.out.println("The program did not produce the expected output.");
            System.out.println();
            System.out.println("\033[1;37mExpected output:\033[0m");
            System.out.println(expected);
            System.out.println("\033[1;37mActual output:\033[0m");
            System.out.println(actual);
            System.out.println();
        }

        public static void error(Exception e) {
            System.out.println(RESULT.FAILED);
            System.out.println("The program did not run successfully.");
            System.out.println();
            System.out.println("\033[1;37mError message:\033[0m");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CodeTester tester = new CodeTester();

        System.out.println("\033[1;34m----------------------------------------\033[0m");
        System.out.println("\033[1;34mRunning tests...\033[0m"); 
        System.out.println("\033[1;34m----------------------------------------\033[0m");

        tester.problem1();
    }

    private void consoleMatch(String expected) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outStream);
        PrintStream oldOut = System.out;

        try {
            System.setOut(newOut);
            String[] args = {};
            Problem_1.main(args);
            System.out.flush();
            System.setOut(oldOut);

            assertEquals(expected.trim(), outStream.toString().trim());
            RESULT.success();
        } catch (AssertionError e) {
            RESULT.mismatch(expected, outStream.toString());
        } catch (Exception e) {
            RESULT.error(e);
        }
    }

    @Test
    public void problem1() {
        System.out.print("\033[1;37mProblem 1 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("//////////////////////");
        expected.append(System.lineSeparator());
        expected.append("|| Victory is mine! ||");
        expected.append(System.lineSeparator());
        expected.append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        consoleMatch(expected.toString());
    }
}
