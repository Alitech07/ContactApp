package spring.contactApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.contactApp.entity.Company;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.CompanyDTO;
import spring.contactApp.repository.CompanyRepository;
import spring.contactApp.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public HttpEntity<?> getCompanies(){
        List<Company> companies = companyService.getCompaniesService();
        return ResponseEntity.ok(companies);
    }

    @PostMapping("/add")
    public HttpEntity<?> addCompany(@RequestBody CompanyDTO companyDTO){
        ApiResponse apiResponse = companyService.addCompanyService(companyDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editCompany(@PathVariable Integer id,@RequestBody CompanyDTO companyDTO){
        ApiResponse apiResponse = companyService.editCompany(id, companyDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteCompany(@PathVariable Integer id){
        ApiResponse apiResponse = companyService.deleteCompanyService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}

