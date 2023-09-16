import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeTester {
    public static void main(String[] args) {
        CodeTester tester = new CodeTester();

        System.out.println("\033[1;34m----------------------------------------\033[0m");
        System.out.println("\033[1;34mRunning tests...\033[0m"); 
        System.out.println("\033[1;34m----------------------------------------\033[0m");
        
        tester.problem1();
        tester.problem2();
    }

    private String passed() {
        return "\u001B[32mPASSED\033[0m";
    }

    private String failed() {
        return "\u001B[31mFAILED\033[0m";
    }

    @Test
    public void problem1() {
        System.out.print("\033[1;37mProblem 1 Results..........\033[0m");
        try {
            assertEquals(2, 1 / 0);
            System.out.println(passed());
        } catch (AssertionError e) {
            System.out.println(failed());
            System.out.println("The program did not produce the expected output.");
        } catch (Exception e) {
            System.out.println(failed());
            System.out.println("The program did not run successfully.");
        }
    }

    @Test
    public void problem2() {
        System.out.print("\033[1;37mProblem 2 Results..........\033[0m");
        try {
            assertEquals(2, 1 + 1);
            System.out.println(passed());
        } catch (AssertionError e) {
            System.out.println(failed());
            System.out.println("The program did not produce the expected output.");
        } catch (Exception e) {
            System.out.println(failed());
            System.out.println("The program did not run successfully.");
        }
    }
}
