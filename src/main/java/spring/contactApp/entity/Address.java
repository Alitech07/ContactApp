package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 5,max = 200)
    @Column(nullable = false)
    private String country;

    @Length(min = 3,max = 200)
    @Column(nullable = false)
    private String city;

    @Size(min = 3,max = 200)
    @Column(nullable = false)
    private String street;

    private String distrinct;
}
