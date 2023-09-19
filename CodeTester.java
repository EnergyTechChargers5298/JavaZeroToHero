import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        tester.Problem_1();
        tester.Problem_2();
        tester.Problem_3();
        tester.Problem_4();
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
    public void Problem_1() {
        System.out.print("\033[1;37mProblem 1 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("//////////////////////");
        expected.append(System.lineSeparator());
        expected.append("|| Victory is mine! ||");
        expected.append(System.lineSeparator());
        expected.append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        consoleMatch(expected.toString());
    }

    @Test
    public void Problem_2() {
        System.out.print("\033[1;37mProblem 2 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("  \\/");
        expected.append(System.lineSeparator());
        expected.append(" \\\\//");
        expected.append(System.lineSeparator());
        expected.append("\\\\\\///");
        expected.append(System.lineSeparator());
        expected.append("///\\\\\\");
        expected.append(System.lineSeparator());
        expected.append(" //\\\\");
        expected.append(System.lineSeparator());
        expected.append("  /\\");
        
        consoleMatch(expected.toString());
    }

    @Test
    public void Problem_3() {
        System.out.print("\033[1;37mProblem 3 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("A well-formed Java program has");
        expected.append(System.lineSeparator());
        expected.append("a main method with { and }");
        expected.append(System.lineSeparator());
        expected.append("braces.");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("A System.out.println statement");
        expected.append(System.lineSeparator());
        expected.append("has ( and ) and usually a");
        expected.append(System.lineSeparator());
        expected.append("String that starts and ends");
        expected.append(System.lineSeparator());
        expected.append("with a \" character.");
        expected.append(System.lineSeparator());
        expected.append("(But we type \\\" instead!)");
        
        consoleMatch(expected.toString());
    }

    @Test
    public void Problem_4() {
        System.out.print("\033[1;37mProblem 4 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("public class Hello {");
        expected.append(System.lineSeparator());
        expected.append("\tpublic static void main(String[] args) {");
        expected.append(System.lineSeparator());
        expected.append("\t\tSystem.out.println(\"Hello, world!\");");
        expected.append(System.lineSeparator());
        expected.append("\t}");
        expected.append(System.lineSeparator());
        expected.append("}");
        
        consoleMatch(expected.toString());
    }
}
