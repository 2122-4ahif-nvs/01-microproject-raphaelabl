package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "Location.findByName",
                query = "Select l from Location l where l.name like :NAME"
        )
)
@Table(name = "LL_LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Location_Name", unique = true)
    @NotBlank(message = "The name from this location can not be blank")
    private String name;

    //region constructors
    public Location() {
    }

    public Location(String name) {
        this.setName(name);
    }
    //endregion

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s", getId(), getName());
    }
}
