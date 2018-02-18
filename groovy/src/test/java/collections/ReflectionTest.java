package collections;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmiro on 13.01.2018.
 */
public class ReflectionTest {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("abc");
        //Как вызвать метод add, используя рефлексию
        Class[] paramTypes = new Class[]{String.class};
        Method addMethod = List.class.getMethod("add", paramTypes);
        Boolean answer = (Boolean) addMethod.invoke(list, "xyz");


        List.class.getDeclaredMethods();
    }
}
