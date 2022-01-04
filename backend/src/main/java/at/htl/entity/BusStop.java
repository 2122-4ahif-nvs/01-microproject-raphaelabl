package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public LocalDateTime stopTime;

    @ManyToOne
    public Bus bus;

    @ManyToOne
    public Station station;



}
