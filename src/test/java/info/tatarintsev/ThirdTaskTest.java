package info.tatarintsev;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Locale;

//import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ThirdTaskTest {

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> data() {
        Object[][] objects = new Object[][]{
                new Object[] { new String("[1, 2, 4, 4, 2, 3, 4, 1, 7]"), new String("assertTrue"), new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7} },
                new Object[] { new String("[1, 2, 4, 4, 2, 3, 4, 1, 7, 8]"), new String("assertTrue"), new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 8} },
                new Object[] { new String("[]"), new String("assertFalse"), new int[]{} },
                new Object[] { new String("[4]"), new String("assertTrue"), new int[]{4} }
        };
        return Arrays.asList(objects);
    }

    class ThirdTaskHelper implements ThirdTask {}

    @Parameterized.Parameter(0)
    public String description;

    @Parameterized.Parameter(1)
    public String methodName;

    @Parameterized.Parameter(2)
    public int[] inputArray;

    @Test
    public void check1and4InArray_test_exists() {
        try {
            // :begin

            // методы могут различаться, assertFalse или assertTrue, поэтому при каждом новом вызове
            // каждый раз находим метод с совпадающей сигнатурой void <methodName> (arg0)>
            Method foundMethod = null;
            Class c = Assert.class;
            Method[] methods = c.getDeclaredMethods();
            for ( Method methodEach: methods) {
                if (methodEach.getName().equals(methodName)
                        && (methodEach.getGenericReturnType() == void.class)
                        && (methodEach.getParameterCount() == 1)) {
                    foundMethod = methodEach;
                    break;
                }
            }
            foundMethod.setAccessible(true);
            ThirdTaskHelper helper = new ThirdTaskHelper();
            // :where
            boolean result = helper.check1and4InArray(inputArray);
            // :result
            foundMethod.invoke(null,result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}