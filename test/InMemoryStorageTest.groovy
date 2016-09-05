import org.junit.Test

/**
 * Created by 123 on 05.09.2016.
 */
class InMemoryStorageTest extends GroovyTestCase {

    def storage = new InMemoryStorage()

    //@Test
    public void testAdd() {
        def car = new Car()
        car.license = "123abc"
        car.model = "Moskvich412"
        storage.add(car)
    }
}
