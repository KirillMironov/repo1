package ui;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 123 on 12.11.2016.
 */
public class Home {
    private SimpleStringProperty address = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();
    private SimpleStringProperty state = new SimpleStringProperty();
    private SimpleStringProperty zip = new SimpleStringProperty();
    private SimpleStringProperty price = new SimpleStringProperty();

    public Home(String address, String city, String state, String zip, String price) {
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPrice(price);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getZip() {
        return zip.get();
    }

    public SimpleStringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
