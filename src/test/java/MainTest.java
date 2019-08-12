import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {

    public static final String ABSENT_EMPLOYEE_NAME = "James K.";
    public static final String PRESENT_EMPLOYEE_NAME = "Сидоров С. С.";
    public static final ArrayList<String> PRESENT_EMPLOYEE_PHONES = new ArrayList<>(Arrays.asList("+8 800 2000 800",
            "+8 800 2000 900", "+8 800 2000 000"));

    @Before
    public void fillPhoneBook() {
        Main.fillPhoneBook();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoArgs() {
        Main.main(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoArgs() {
        Main.main(new String[]{ABSENT_EMPLOYEE_NAME, PRESENT_EMPLOYEE_NAME});
    }

    @Test
    public void testNotPresent() {
        ArrayList<String> result = Main.getPhones(ABSENT_EMPLOYEE_NAME);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(Main.NO_EMPLOYEE, result.get(0));
    }

    @Test
    public void testPresent() {
        ArrayList<String> result = Main.getPhones(PRESENT_EMPLOYEE_NAME);
        Assert.assertEquals(PRESENT_EMPLOYEE_PHONES.size(), result.size());
        for (int i = 0; i < PRESENT_EMPLOYEE_PHONES.size(); i++) {
            Assert.assertEquals(PRESENT_EMPLOYEE_PHONES.get(i), result.get(i));
        }
    }
}
