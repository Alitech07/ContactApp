package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @OneToOne(optional = false,cascade = CascadeType.PERSIST)
    private Address address;

    @OneToMany(mappedBy = "company")
    private Set<Branch> branch;
}
