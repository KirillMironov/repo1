import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Created by 123 on 06.11.2016.
 */
public class ExceptionJavaTest {

    public void calculate1(int i) throws Exception {
        /*if (i == 1) {
            throw new IOException();
        } else if (i == 2) {
            throw new SQLException();
        } else if (i == 3) {
            throw new MalformedURLException();
        } else {
            //throw new Exception();
        }*/
        switch (i) {
            case 1:
                throw new IOException();
            case 2:
                throw new SQLException();
            case 3:
                throw new MalformedURLException();
            default:
                throw new Exception();
        }
    }

    public void calculate11(int i) {
        try {
            calculate1(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calculate2() {
        throw new RuntimeException();
    }

    @Test
    public void testCalculate11() {
        try {
            calculate11(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCalculate2() {
        calculate2();
    }
}
