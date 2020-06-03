package hr.croz.unicorn.model;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name = "article", schema = "sc_unicorn")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "action_id")
    private Long actionId;

    @Transient
    private Double finalPrice;

    @JoinColumn(name = "action_id", insertable = false, updatable = false)
    @OneToOne
    private Action action;

}
