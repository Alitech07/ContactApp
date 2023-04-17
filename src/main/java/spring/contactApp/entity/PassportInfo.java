package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PassportInfo {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 2,max = 2)
    @Column(nullable = false,unique = true)
    private String seria;

    @Column(nullable = false,unique = true)
    private Long number;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(nullable = false)
    private String placeOfBirth;

    @Column(nullable = false)
    private Date dateOfIssue;

    @Column(nullable = false)
    private Date dateOfExpire;
}
