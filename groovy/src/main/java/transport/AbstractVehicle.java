package transport;

/**
 * Created by 123 on 12.02.2017.
 */
public abstract class AbstractVehicle implements Vehicle {
    public void insertKey() {

    }

    public void turnKey(){

    }

    public void waitAndReleaseKey(){

    }

    public void startEngine(){
        insertKey();
        turnKey();
        waitAndReleaseKey();
    }


    public void stopEngine(){
        turnKeyLeft();
        takeKeyOut();
    }

    public void takeKeyOut() {

    }

    public void turnKeyLeft() {

    }

}
