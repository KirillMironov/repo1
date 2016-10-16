
import java.text.SimpleDateFormat

/**
 * Created by 123 on 25.09.2016.
 */
class TimeAndDateTest extends GroovyTestCase {
    public void test() {
        long timestamp = System.currentTimeMillis()
        Date date = new Date()
        Date zero = new Date(0)
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss.SSS zzzzzzzzzzzzzzzzzz")
        df.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"))
        println(df.format(date))
        println(timestamp)
        println(date)
        println(zero)
    }
}
