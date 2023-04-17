package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.contactApp.entity.Address;
import spring.contactApp.entity.Company;
import spring.contactApp.repository.CompanyRepository;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.CompanyDTO;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    /**
     * Barcha companiya larni olish,
     * @return
     */
    public List<Company> getCompaniesService(){
        return companyRepository.findAll();
    }

    /**
     * COMPANIYANI ID SI BO'YICHA OLISH.
     * @param id
     * @return
     */
    public Company getCompanyService(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.orElse(null);
    }

    /**
     * YANGI KOMPANIYA QO'SHISH.
     * @param companyDTO
     * @return
     */
    public ApiResponse addCompanyService(CompanyDTO companyDTO){
        boolean exists = companyRepository.existsByName(companyDTO.getName());
        if (exists) return new ApiResponse("Bunday nomli kompaniya mavjud.",false);

        Company company = new Company();
        company.setName(companyDTO.getName());

        Address address = new Address();
        address.setCity(companyDTO.getAddressDTO().getCity());
        address.setCountry(companyDTO.getAddressDTO().getCountry());
        address.setStreet(companyDTO.getAddressDTO().getStreet());
        address.setDistrinct(companyDTO.getAddressDTO().getDistrinct());
        company.setAddress(address);
        companyRepository.save(company);
        return new ApiResponse("Kompaniya saqlandi.",true);
    }

    /**
     * COMPANIYA MA'LUMOTLARINI TAHRIRLASH.
     * @param id
     * @param companyDTO
     * @return
     */
    public ApiResponse editCompany(Integer id,CompanyDTO companyDTO){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent()) return new ApiResponse("Bunday companiya mavjud emas.",false);
        Company company = optionalCompany.get();
        company.setName(companyDTO.getName());

        Address address = company.getAddress();
        address.setCountry(companyDTO.getAddressDTO().getCountry());
        address.setCity(companyDTO.getAddressDTO().getCity());
        address.setStreet(companyDTO.getAddressDTO().getStreet());
        address.setDistrinct(companyDTO.getAddressDTO().getDistrinct());
        company.setAddress(address);
        companyRepository.save(company);
        return new ApiResponse("Kompniya malumotlari tahrirlandi.",true);
    }

    /**
     * COMPANIYA MALUMOTLARINI O'CHIRISH.
     * @param id
     * @return
     */
    public ApiResponse deleteCompanyService(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent()) return new ApiResponse("Bunday kampaniya mavjud emas.",false);
        companyRepository.deleteById(id);
        return new ApiResponse("Companiya o'chirildi.",true);
    }
}
