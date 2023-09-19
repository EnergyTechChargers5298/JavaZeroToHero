import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.Test;

import pset.Problem_1;
import pset.Problem_2;
import pset.Problem_3;
import pset.Problem_4;
import pset.Problem_5;
import pset.Problem_6;
import pset.Problem_7;
import pset.Problem_8;
import pset.Problem_9;

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

        public static void condensedMismatch() {
            System.out.println(RESULT.FAILED);
            System.out.println("The program did not produce the expected output.");
            System.out.println();
        }

        public static void atleast(int expected, int actual) {
            System.out.println(RESULT.FAILED);
            System.out.println("The program does not have enough methods.");
            System.out.println();
            System.out.println("\033[1;37mExpected minimum:\033[0m " + expected);
            System.out.println("\033[1;37mActual amount:\033[0m " + actual);
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

    private void consoleMatch(String expected, Runnable runnable) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outStream);
        PrintStream oldOut = System.out;

        try {
            System.setOut(newOut);
            runnable.run();
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

    private void consoleMatchCondensed(String expected, Runnable runnable) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outStream);
        PrintStream oldOut = System.out;

        try {
            System.setOut(newOut);
            runnable.run();
            System.out.flush();
            System.setOut(oldOut);
            
            assertEquals(expected.trim(), outStream.toString().trim());
            RESULT.success();
        } catch (AssertionError e) {
            RESULT.condensedMismatch();
        } catch (Exception e) {
            RESULT.error(e);
        }
    }

    private void atLeastNum(int expected, int actual) {
        try {
            assertTrue(actual >= expected);
            RESULT.success();
        } catch (AssertionError e) {
            RESULT.atleast(expected, actual);
        } catch (Exception e) {
            RESULT.error(e);
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
        tester.Problem_5();
        tester.Problem_5_2();
        tester.Problem_6();
        tester.Problem_6_2();
        tester.Problem_7();
        tester.Problem_7_2();
        tester.Problem_8();
        tester.Problem_8_2();
        tester.Problem_9();
    }

    public static String args[] = {};

    @Test
    public void Problem_1() {
        System.out.print("\033[1;37mProblem 1 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("//////////////////////");
        expected.append(System.lineSeparator());
        expected.append("|| Victory is mine! ||");
        expected.append(System.lineSeparator());
        expected.append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        consoleMatch(expected.toString(), () -> Problem_1.main(args));
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
        
        consoleMatch(expected.toString(), () -> Problem_2.main(args));
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
        
        consoleMatch(expected.toString(), () -> Problem_3.main(args));
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
        
        consoleMatch(expected.toString(), () -> Problem_4.main(args));
    }

    @Test
    public void Problem_5() {
        System.out.print("\033[1;37mProblem 5 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("There's one thing every coder must understand:");
        expected.append(System.lineSeparator());
        expected.append("The System.out.println command.");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("There's one thing every coder must understand:");
        expected.append(System.lineSeparator());
        expected.append("The System.out.println command.");

        
        consoleMatch(expected.toString(), () -> Problem_5.main(args));
    }

    @Test
    public void Problem_5_2() {
        System.out.print("\033[1;37mProblem 5 Chant............\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("There's one thing every coder must understand:");
        expected.append(System.lineSeparator());
        expected.append("The System.out.println command.");
        
        consoleMatch(expected.toString(), () -> Problem_5.chant());
    }

    @Test
    public void Problem_6() {
        System.out.print("\033[1;37mProblem 6 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        expected.append(System.lineSeparator());
        expected.append("You're the best,");
        expected.append(System.lineSeparator());
        expected.append("In the West.");
        expected.append(System.lineSeparator());
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        expected.append(System.lineSeparator());
        expected.append("You're the best,");
        expected.append(System.lineSeparator());
        expected.append("In the West.");
        expected.append(System.lineSeparator());
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("Go, team, go!");
        expected.append(System.lineSeparator());
        expected.append("You can do it.");
        
        consoleMatch(expected.toString(), () -> Problem_6.main(args));
    }

    @Test
    public void Problem_6_2() {
        System.out.print("\033[1;37mProblem 6 Methods..........\033[0m");
        Method[] methods = Problem_6.class.getDeclaredMethods();
        atLeastNum(3, methods.length);
    }

    @Test
    public void Problem_7() {
        System.out.print("\033[1;37mProblem 7 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("   ______");
        expected.append(System.lineSeparator());
        expected.append("  /      \\");
        expected.append(System.lineSeparator());
        expected.append(" /        \\");
        expected.append(System.lineSeparator());
        expected.append(" \\        /");
        expected.append(System.lineSeparator());
        expected.append("  \\______/");
        expected.append(System.lineSeparator());
        expected.append("    ______");
        expected.append(System.lineSeparator());
        expected.append("   /      \\");
        expected.append(System.lineSeparator());
        expected.append("  /        \\");
        expected.append(System.lineSeparator());
        expected.append("  \\        /");
        expected.append(System.lineSeparator());
        expected.append("   \\______/");
        expected.append(System.lineSeparator());
        expected.append(" +--------+");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("   ______");
        expected.append(System.lineSeparator());
        expected.append("  /      \\");
        expected.append(System.lineSeparator());
        expected.append(" /        \\");
        expected.append(System.lineSeparator());
        expected.append(" |  STOP  |");
        expected.append(System.lineSeparator());
        expected.append(" \\        /");
        expected.append(System.lineSeparator());
        expected.append("  \\______/");
        expected.append(System.lineSeparator());
        expected.append(" +--------+");

        consoleMatch(expected.toString(), () -> Problem_7.main(args));
    }

    @Test
    public void Problem_7_2() {
        System.out.print("\033[1;37mProblem 7 Methods..........\033[0m");
        Method[] methods = Problem_7.class.getDeclaredMethods();
        atLeastNum(3, methods.length);
    }

    @Test
    public void Problem_8() {
        System.out.print("\033[1;37mProblem 8 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append("*****");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        expected.append(System.lineSeparator());
        expected.append("  *  ");
        expected.append(System.lineSeparator());
        expected.append(" * * ");
        
        consoleMatch(expected.toString(), () -> Problem_8.main(args));
    }

    @Test
    public void Problem_8_2() {
        System.out.print("\033[1;37mProblem 8 Methods..........\033[0m");
        Method[] methods = Problem_8.class.getDeclaredMethods();
        atLeastNum(3, methods.length);
    }

    @Test
    public void Problem_9() {
        System.out.print("\033[1;37mProblem 9 Results..........\033[0m");

        StringBuilder expected = new StringBuilder();
        for(int i = 0; i < 1000; i++) {
            expected.append("All work and no play makes Jack a dull boy.");
        }

        consoleMatchCondensed(expected.toString(), () -> Problem_9.main(args));
    }
}
