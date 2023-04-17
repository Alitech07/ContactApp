package spring.contactApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    @NotNull
    @Size(min = 5,max = 200)
    private String country;

    @NotNull
    @Length(min = 3,max = 200)
    private String city;

    @NotNull
    @Size(min = 3,max = 200)
    private String street;

    private String distrinct;
}
