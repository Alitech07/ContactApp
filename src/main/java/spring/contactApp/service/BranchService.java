package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.contactApp.entity.Address;
import spring.contactApp.entity.Branch;
import spring.contactApp.entity.Company;
import spring.contactApp.payload.AddressDTO;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.BranchDTO;
import spring.contactApp.repository.BranchRepository;
import spring.contactApp.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    CompanyRepository companyRepository;

    public List<Branch> getBranchesService(){
        return branchRepository.findAll();
    }

    public Branch getBranchService(Integer id){
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        return optionalBranch.orElse(null);
    }

    public ApiResponse addBranchService(BranchDTO branchDTO){
        boolean existsed = branchRepository.existsBranchByName(branchDTO.getName());
        if (existsed) return new ApiResponse("Bunday nomli filial mavjud.",false);
        Branch branch = new Branch();
        branch.setName(branchDTO.getName());

        Optional<Company> optionalCompany = companyRepository.findById(branchDTO.getCompanyId());
        if (!optionalCompany.isPresent()) return new ApiResponse("Bunday kampaniya mavjud emas.",false);

        branch.setCompany(optionalCompany.get());

        Address address = new Address();
        address.setCountry(branchDTO.getAddressDTO().getCountry());
        address.setCity(branchDTO.getAddressDTO().getCity());
        address.setStreet(branchDTO.getAddressDTO().getStreet());
        address.setDistrinct(branchDTO.getAddressDTO().getDistrinct());

        branch.setAddress(address);
        branchRepository.save(branch);

        return new ApiResponse("Fillial qo'shildi.",true);
    }

    public ApiResponse deleteBranchService(Integer id){
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (!optionalBranch.isPresent()) return new ApiResponse("Bunday filial mavjud emas.",false);
        branchRepository.deleteById(id);
        return new ApiResponse("Filial o'chirildi.",true);
    }
}
