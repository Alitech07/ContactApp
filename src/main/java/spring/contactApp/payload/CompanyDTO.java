package spring.contactApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.contactApp.entity.Address;
import spring.contactApp.entity.Branch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    @NotNull
    @Size(min = 2)
    private String name;
    private AddressDTO addressDTO;
}
