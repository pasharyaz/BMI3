import app.entities.BmiDataImpl;
import app.servlets.SubmitServlet;
import org.junit.Assert;
import org.junit.Test;


public class BMITest {
    private BmiDataImpl bmiDataImplTest;

    public static void main(String[] args) {
        zeroValuesTest();
        invalidValuesTest();
        belowZeroValuesTest();
        validValuesTest();
    }

    @Test
    private static void tryTest() {

    }

    @Test
    private static void zeroValuesTest() {
        BmiDataImpl bmiDataImpl = new BmiDataImpl("0", "6");
        BMITest bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("7.3", "0");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("0", "0");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);
    }

    @Test
    private static void invalidValuesTest() {
        BmiDataImpl bmiDataImpl = new BmiDataImpl("a1sd", "6");
        BMITest bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("7.3", "a23 sd");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);


        bmiDataImpl = new BmiDataImpl("asd ", "qwr y1");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);


    }

    @Test
    private static void belowZeroValuesTest() {
        BmiDataImpl bmiDataImpl = new BmiDataImpl("-7", "6");
        BMITest bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("7.3", "-14");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("-10", "-12");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(0, bmiTest.bmiDataImplTest.getBmi(), 0.1);
    }

    @Test
    private static void validValuesTest() {
        BmiDataImpl bmiDataImpl = new BmiDataImpl("170", "110");
        BMITest bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(38.06, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("184.4", "72.2");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(21.23, bmiTest.bmiDataImplTest.getBmi(), 0.1);

        bmiDataImpl = new BmiDataImpl("196.4", "47.4");
        bmiTest = new BMITest(bmiDataImpl);
        Assert.assertEquals(12.29, bmiTest.bmiDataImplTest.getBmi(), 0.1);
    }

    private BMITest(BmiDataImpl bmiDataImplTest) {
        this.bmiDataImplTest = bmiDataImplTest;
    }
}
