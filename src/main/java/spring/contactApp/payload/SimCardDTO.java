package spring.contactApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.contactApp.entity.Packet;
import spring.contactApp.entity.PassportInfo;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimCardDTO {
    @Size(min = 4,max = 4)
    private String countryCode;

    @Size(min = 2,max =2)
    private Integer companyCode;

    private Long number;
    private double balance;
    private Integer tarifId;
    private List<Packet> packets;
    private PassportInfo passportInfo;

}
