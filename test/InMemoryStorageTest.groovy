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
        car = new Car(license: "456def", model: "audi100")
        storage.add(car)
        for (i in 0..storage.cars.length - 1) {
            car = storage.cars[i]
            if (car != null) {
                println("i=" + i + ", " + car)
            }
        }
    }

    //@Test
    public void testLicense () {
        def car = new Car()
        car.license = "123abc"
        car.model = "Moskvich412"
        storage.cars[3] = car

        def foundCar = storage.find("123abc")

        assert foundCar.license == "123abc"

        foundCar = storage.find("123xyz")

        assert foundCar == null

    }
}
