import engine.BinomialCoefficients;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.math.BigInteger.valueOf;

public class BinomialCoefficientsTest {

    private static List<BigInteger> inputValues;
    private static Queue<BigInteger> expectedValues;

    private static List<BigInteger> fillInputValues() {
        inputValues = new ArrayList<>();
        inputValues.add(valueOf(1));
        inputValues.add(valueOf(7));
        inputValues.add(valueOf(15));
        inputValues.add(valueOf(20));
        inputValues.add(valueOf(25));
        inputValues.add(valueOf(50));
        return inputValues;
    }

    private static Queue<BigInteger> fillExpectedValues() {
        expectedValues = new LinkedList<>();
        expectedValues.add(valueOf(2));
        expectedValues.add(valueOf(3432));
        expectedValues.add(valueOf(155117520));
        expectedValues.add(new BigInteger("137846528820"));
        expectedValues.add(new BigInteger("126410606437752"));
        expectedValues.add(new BigInteger("100891344545564193334812497256"));
        return expectedValues;
    }

    @org.junit.BeforeClass
    public static void setUp() {
        inputValues = fillInputValues();
        expectedValues = fillExpectedValues();
    }

    @org.junit.AfterClass
    public static void tearDown() {
        inputValues.clear();
        expectedValues.clear();
    }

    @org.junit.Test
    public void computeBinomialCoefficientsWithValidValues() {
        for (BigInteger inputValue : inputValues)
            Assert.assertEquals(expectedValues.remove(), BinomialCoefficients.computeBinomialCoefficients(inputValue.intValue()));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void computeBinomialCoefficientsWithInvalidValue() {
        BinomialCoefficients.computeBinomialCoefficients(-15);
    }
}