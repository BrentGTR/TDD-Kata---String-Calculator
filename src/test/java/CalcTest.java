import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {
    @Test
    public void testEmptyString() {
        Assert.assertEquals(Calc.add(""),0);
    }
    @Test
    public void testOneNumber() {
        Assert.assertEquals(Calc.add("8"),8);
    }
    @Test
    public void testTwoNumbers() {
        Assert.assertEquals(Calc.add("8,2"),10);
    }
    @Test
    public void testMultipleNumbers() {
        Assert.assertEquals(Calc.add("8,2,3"),13);
    }
    @Test
    public void testNewLine() {
        Assert.assertEquals(Calc.add("8\n2,3"),13);
    }
    @Test
    public void testOtherDelimiter() {
        Assert.assertEquals(Calc.add("//;\n1;2"),3);
    }
    @Test
    public void testNegativeNumber() {
        try{
            Assert.assertEquals(Calc.add("-1, -2"),"negatives not allowed -1 -2 ");
        }catch (IllegalArgumentException e){
            System.out.print(e);
        }
    }
    @Test
    public void testOverThousand() {
        Assert.assertEquals(Calc.add("//;\n1;2000"),1);
    }
    @Test
    public void testLongDelimiters() {
        Assert.assertEquals(Calc.add("//[***]\n1***2***3"),6);
    }
    @Test
    public void testMultipleDelimiters() {
        Assert.assertEquals(Calc.add("//[*][%]\n1*2%3"),6);
    }
    @Test
    public void testMultipleLongDelimiters() {
        Assert.assertEquals(Calc.add("//[***][%%%]\n1***2%%%3"),6);
    }
}
