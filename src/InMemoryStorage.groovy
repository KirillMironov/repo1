/**
 * Created by 123 on 05.09.2016.
 */
class InMemoryStorage {

    final int ARRAY_SIZE = 100

    Car[] cars = new Car[ARRAY_SIZE]

    def add(Car car) {
        car.license.toString()
        int index = car.license.hashCode() % ARRAY_SIZE
        cars[index] = car
    }

}
