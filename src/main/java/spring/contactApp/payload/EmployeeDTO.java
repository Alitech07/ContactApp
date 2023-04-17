package spring.contactApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring.contactApp.entity.Branch;
import spring.contactApp.entity.Company;
import spring.contactApp.entity.PassportInfo;
import spring.contactApp.entity.Role;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotNull
    @Size(min = 3,max = 50)
    private String firstName;

    @NotNull
    @Size(min = 2,max = 50)
    private String lastName;

    @NotNull
    @Size(min = 9,max = 200)
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private Integer branchId;

    @NotNull
    private PassportInfo passportInfo;

    @NotNull
    private Integer companyId;
}
