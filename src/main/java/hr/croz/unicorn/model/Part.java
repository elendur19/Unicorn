package hr.croz.unicorn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "part", schema = "sc_unicorn")
@Data
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "serial_number", unique = true)
    private String serialNumber;

    @Column(name = "date_produced")
    private LocalDate dateProduced;

}
