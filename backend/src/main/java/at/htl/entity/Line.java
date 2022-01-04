package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(
        name = "Line.findByName",
        query = "Select l from Line l where l.name like :NAME"
)
@Table(name = "LL_LINE")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "There is no line without a name")
    @Column(name = "Line_Name", unique = true)
    private String name;

    //region constructors
    public Line() {
    }

    public Line(String name) {
        this.name = name;
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
        return String.format("%d: %s", id, name);
    }
}
