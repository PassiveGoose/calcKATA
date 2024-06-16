import org.junit.Assert;
import org.junit.Test;

public class TestCalculation {

    @Test
    public void testSimpleArabic() {
        String input = "1 + 5";
        testNormal(input, "6");
    }

    @Test
    public void testSimpleRoman() {
        String input = "X - II";
        testNormal(input, "VIII");
    }

    @Test
    public void testMixed() {
        String input = "1 * V";
        testException(input);
    }

    @Test
    public void testEmpty() {
        String input = "";
        testException(input);
    }

    @Test
    public void testOverflowed() {
        String input = "1 + 5 * 4";
        testException(input);
    }

    @Test
    public void testWithNextLineJump() {
        String input = "1 + \n5";
        testException(input);
    }

    @Test
    public void testTooBigValues() {
        String input = "1000 - 7";
        testException(input);
    }

    @Test
    public void testWrongRoman() {
        String input = "IIII + II";
        testException(input);
    }

    @Test
    public void testWrongRomanResult() {
        String input = "I - V";
        testException(input);
    }

    private void testNormal(String input, String expected) {
        try {
            String result = Main.calc(input);
            Assert.assertEquals(expected, result);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    private void testException(String input) {
        try {
            Main.calc(input);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

}
