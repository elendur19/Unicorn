package hr.croz.unicorn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "car", schema = "sc_unicorn")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand_id")
    private Long brandId;

    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    @ManyToOne
    private Brand brand;

}
