package at.htl.entity;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BusId;

    int seat;

    String brand;

    String type;

    // region constructors
    public Bus(int seat, String brand, String type) {
        this.seat = seat;
        this.brand = brand;
        this.type = type;
    }

    public Bus() {
    }
    // endregion constructors

    //region getter setter

    public long getBusId() {
        return BusId;
    }

    public void setBusId(long busId) {
        BusId = busId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //endregion

    @Override
    public String toString() {
        return "Bus{" +
                "BusId=" + BusId +
                ", seat=" + seat +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
