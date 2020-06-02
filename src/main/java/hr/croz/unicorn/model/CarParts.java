package hr.croz.unicorn.model;

import javax.persistence.*;

@Entity
@Table(name = "car_part", schema = "sc_unicorn")
public class CarParts {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    @ManyToOne
    @JoinColumn(name = "part_id")
    Part part;
}
