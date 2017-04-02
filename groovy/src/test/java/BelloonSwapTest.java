import org.junit.Test;

/**
 * Created by 123 on 11.12.2016.
 */
public class BelloonSwapTest {
    private static void foo(Balloon balloon) { //balloon=100
        balloon.setColor("Red"); //balloon=100
        balloon = new Balloon("Green"); //balloon=200
        balloon.setColor("Blue"); //balloon = 200
    }

    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1; //temp<-red
        o1=o2; //o1<-blue
        o2=temp; //o2<-red
    }

    @Test
    public void test() {
        Balloon red = new Balloon("Red"); //memory reference 50
        Balloon blue = new Balloon("Blue"); //memory reference 100

        swap(red, blue);
        System.out.println("red color="+red.getColor());
        System.out.println("blue color="+blue.getColor());

        foo(blue);
        System.out.println("blue color="+blue.getColor());
    }

    /*
    Balloon red = new Balloon("Red"); //memory reference 50
    Balloon blue = new Balloon("Blue"); //memory reference 100

    swap(red, blue);
    System.out.println("red color="+red.getColor());
    System.out.println("blue color="+blue.getColor());

    foo(blue);
    System.out.println("blue color="+blue.getColor());
    */
}
