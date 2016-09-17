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
    Car find(String license){
        Car car = null
        for (i in 0..cars.length - 1) {
            println(cars[i])
            if (cars[i] != null){
                if (license == cars[i].license) {
                    car = cars[i]
                    break
                }
            }
        }
        return car
    }

}
