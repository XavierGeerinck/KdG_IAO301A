package be.kdg.jutil;

/**
 * @author Kristiaan Behiels
 * @version 1.0 1-mei-2006
 */
public class TestAll {
    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main(
              "be.kdg.jutil.TestWinkelWagentje",
              "be.kdg.jutil.TestWinkelWagentjeMetObjectMother");
    }
}
