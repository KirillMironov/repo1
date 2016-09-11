/**
 * Created by 123 on 05.09.2016.
 */
class InMemoryStorage {
    Car[] cars = new Car[10000]

    def add(Car car) {
        car.license.toString()
        cars[car.license.hashCode() % 10000] = car
        println(car)
    }

}
