package hr.croz.unicorn.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity()
@Table(name = "action", schema = "sc_unicorn")
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "beginning")
    private LocalDate beginningDate;

    @Column(name = "end")
    private LocalDate endDate;

    @Column(name = "action_percentage")
    private int actionPercentage;

}
