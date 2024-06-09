import org.junit.Assert;
import org.junit.Test;

public class TestCalculation {

    @Test
    public void testSimpleArabic() {
        String input = "1 + 5";
        try {
            String result = Main.calc(input);
            Assert.assertEquals(result, "6");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testSimpleRoman() {
        String input = "X - II";
        try {
            String result = Main.calc(input);
            Assert.assertEquals(result, "VIII");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testMixed() {

    }

    @Test
    public void testEmpty() {

    }

    @Test
    public void testOverflowed() {

    }

    @Test
    public void testWithNextLineJump() {

    }
}
