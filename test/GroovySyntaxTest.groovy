import org.junit.Test

/**
 * Created by 123 on 10.09.2016.
 */
class GroovySyntaxTest extends GroovyTestCase{
    //@Test
    public void testExpression(){
        // литералы, literals
        // int
        0
        1
        // double
        0.0
        1.07
        // Символы, characters
        ' '
        'a'
        '\n'
        // строка, String
        ""
        " "
        "abc"
        "\0x0" // nul
        "\n" // new line
        "\t" // табуляция 4 или 8 позиций
        // boolean
        true
        false
        // объявление переменных
        byte b = -1
        int i1 = 3
        double f1 = 1.9
        boolean bool = true
        String s = "xyz"
        int x = f1
        println(x)

        // выражения, expressions
        int i2 = 7 - 3
        int i3 = i1 * i2 + 7
        double f2 = f1 * 0.1 + 3
        println("f2 =" + f2)
        int i4 = f1 + 1
        println("i4 =" + i4)
        String s2 = 0.3 ** 2
        println(s2)
        println("e**2 =" + Math.exp(2.0))
        boolean b1 = true
        boolean b2 = false
        println("b1 AND b2 =" +(b1 && b2))
        println("b1 or b2 =" +(b1 || b2))


    }
}
