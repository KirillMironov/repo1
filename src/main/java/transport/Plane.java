package transport;

/**
 * Created by 123 on 12.02.2017.
 */
public class Plane extends AbstractVehicle {
    public void startEngine(){
        super.insertKey();
        turnKey();
        turnOnElectricalSystems();
        startEngine1();
        waitUntilRotationSpeedReachesExpected();
        startEngine2();
        waitUntilRotationSpeedReachesExpected();
    }

    @Override
    public void wash() {

    }

    private void startEngine2() {

    }

    private void waitUntilRotationSpeedReachesExpected() {

    }

    private void startEngine1() {

    }

    private void turnOnElectricalSystems() {

    }
}
