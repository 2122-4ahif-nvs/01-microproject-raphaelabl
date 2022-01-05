package at.htl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long busId;

    public int seat;

    @NotBlank(message="Brand may not be blank")
    public String brand;

    @NotBlank(message="Type may not be blank")
    public String type;

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
        return busId;
    }

    public void setBusId(long busId) {
        busId = busId;
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
                "BusId=" + busId +
                ", seat=" + seat +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
