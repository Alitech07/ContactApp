package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.contactApp.entity.USSD;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tariff {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "tariffs")
    private List<USSD> ussdCode;

    private String type;

    @Column(nullable = false)
    private Double planPrice;

    @Column(nullable = false)
    private double switchPrice;

    @Column(nullable = false)
    private Date expireDate;

    @Column(nullable = false)
    private double mb;

    @Column(nullable = false)
    private Integer sms;

    @Column(nullable = false)
    private double minuts;

    private boolean active;
}
