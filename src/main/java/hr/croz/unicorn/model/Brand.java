package hr.croz.unicorn.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brand", schema = "sc_unicorn")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
