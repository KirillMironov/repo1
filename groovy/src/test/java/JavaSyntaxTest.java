import org.junit.Test;

/**
 * Created by 123 on 10.12.2016.
 */
public class JavaSyntaxTest {
    @Test
    public void test() {
        int x = 1;
        long y = 3;
        long z = x + y;
        Integer x1o = 7;
        Integer x2o = 3;
        Integer x3o = x1o;
        System.out.println(x3o);
        int result = sum(1, 2);
        Integer result2 = sum(new Integer(1), new Integer(2));
        result2 = sum(x1o , x2o);
    }

    private int sum(int p1, int p2) {
        return p1 + p2;
    }

    private Integer sum(Integer p1, Integer p2) {
        return p1 + p2;
    }

    @Test
    public void testCar() {
        Car car = new Car("audi", "123");
        updateLicence(car, "321");
        System.out.println(car);
    }

    public void updateLicence(Car car, String newLicence) {
        car.license = newLicence;
    }
}


