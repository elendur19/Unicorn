package hr.croz.unicorn.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car_part", schema = "sc_unicorn")
@Data
public class CarParts {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;
}
