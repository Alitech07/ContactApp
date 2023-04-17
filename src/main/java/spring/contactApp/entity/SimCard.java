package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SimCard {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false,unique = true)
    private String countryCode;

    @Column(nullable = false,unique = true)
    private Integer companyCode;

    @Column(nullable = false,unique = true)
    private Long number;

    @Column(nullable = false)
    private double balance=0;

    @OneToOne
    private Tariff tariff;

    @OneToMany(mappedBy = "simCard")
    private List<Packet> packet;

    @OneToOne
    private PassportInfo clientPI;

    private boolean active;
}
