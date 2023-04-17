package spring.contactApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.contactApp.entity.Address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {

    @Size(min = 3,max = 150)
    private String name;

    @NotNull
    private Integer companyId;

    @NotNull
    private AddressDTO addressDTO;
}
