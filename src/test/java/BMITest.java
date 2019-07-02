import app.entities.BmiData;
import org.junit.Assert;
import org.junit.Test;


public class BMITest {
    private BmiData bmiDataTest;

    public static void main(String[] args) {
        zeroValuesTest();
        invalidValuesTest();
        belowZeroValuesTest();
        validValuesTest();
    }

    @Test
    static void zeroValuesTest() {
        BmiData bmiData = new BmiData("0", "6");
        BMITest bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("7.3", "0");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("0", "0");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);
    }

    @Test
    static void invalidValuesTest() {
        BmiData bmiData = new BmiData("a1sd", "6");
        BMITest bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("7.3", "a23 sd");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);


        bmiData = new BmiData("asd ", "qwr y1");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);


    }

    @Test
    static void belowZeroValuesTest() {
        BmiData bmiData = new BmiData("-7", "6");
        BMITest bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("7.3", "-14");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("-10", "-12");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(0, bmiTest.bmiDataTest.getBmi(), 0.1);
    }

    @Test
    static void validValuesTest() {
        BmiData bmiData = new BmiData("170", "110");
        BMITest bmiTest = new BMITest(bmiData);
        Assert.assertEquals(38.06, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("184.4", "72.2");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(21.23, bmiTest.bmiDataTest.getBmi(), 0.1);

        bmiData = new BmiData("196.4", "47.4");
        bmiTest = new BMITest(bmiData);
        Assert.assertEquals(12.29, bmiTest.bmiDataTest.getBmi(), 0.1);
    }

    public BMITest(BmiData bmiDataTest) {
        this.bmiDataTest = bmiDataTest;
    }
}
