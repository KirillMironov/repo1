package transport;

/**
 * Created by 123 on 12.02.2017.
 */
public class Train extends AbstractVehicle {
    public void stopEngine(){
        pressStopEngineButton();
        super.stopEngine();
    }

    @Override
    public void wash() {

    }

    private void pressStopEngineButton() {

    }
}
