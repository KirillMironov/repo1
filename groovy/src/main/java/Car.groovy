/**
 * Created by 123 on 05.09.2016.
 */
class Car {
    public String model
    public String license

    Car() {
    }

    Car(String model, String license) {
        this.model = model
        this.license = license
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
