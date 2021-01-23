import info.tatarintsev.EmptyAfter4Exception;
import info.tatarintsev.SecondTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SecondTaskTest {

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> data() {
        Object[][] objects = new Object[][]{
                new Object[] { new String("[1, 2, 4, 4, 2, 3, 4, 1, 7]"), new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7} },
                new Object[] { new String("[1, 2, 4, 4, 2, 3, 4, 1, 7, 8]"), new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 8}, new int[]{1, 7} },
                new Object[] { new String("[]"), new int[]{}, new int[]{1, 7} },
                new Object[] { new String("[4]"), new int[]{4}, new int[]{} }
        };
        return Arrays.asList(objects);
    }

    class SecondTaskHelper implements SecondTask {}

    @Parameterized.Parameter(0)
    public String description;

    @Parameterized.Parameter(1)
    public int[] inputArray;

    @Parameterized.Parameter(2)
    public int[] checkArray;

    @Test
    public void secondTask_run_checkResultArray()  {
        // :begin
        SecondTaskHelper secondTaskHelper = new SecondTaskHelper();
        // :where
        int[] resultArray = secondTaskHelper.secondTaskAction(inputArray);
        // :result
        Assert.assertArrayEquals(resultArray, checkArray);
    }

    @Test(expected = EmptyAfter4Exception.class)
    public void secondTask_run_expectedRequestedException() {
        // :begin
        SecondTaskHelper secondTaskHelper = new SecondTaskHelper();
        // :where
        int[] resultArray = secondTaskHelper.secondTaskAction(inputArray);
    }
}
