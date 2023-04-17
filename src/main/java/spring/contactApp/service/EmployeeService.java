package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.contactApp.entity.Branch;
import spring.contactApp.entity.Company;
import spring.contactApp.entity.Employee;
import spring.contactApp.entity.Role;
import spring.contactApp.entity.enums.RoleName;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.EmployeeDTO;
import spring.contactApp.repository.BranchRepository;
import spring.contactApp.repository.CompanyRepository;
import spring.contactApp.repository.EmployeeRepository;
import spring.contactApp.repository.RoleRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    BranchRepository branchRepository;

    public List<Employee> getEmployeesService(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeService(UUID id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }
    public ApiResponse addEmployeeService(EmployeeDTO employeeDTO){
        Employee employee =new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());
        employee.setRole(roleRepository.getRoleByRoleName(RoleName.ROLE_NAME_EMPLOYE));
        Optional<Company> optionalCompany = companyRepository.findById(employeeDTO.getCompanyId());
        if (!optionalCompany.isPresent()) return new ApiResponse("Bunday kompaniya mavjud emas.",false);
        employee.setCompany(optionalCompany.get());
        employee.setPassportInfo(employeeDTO.getPassportInfo());
        Optional<Branch> optionalBranch = branchRepository.findById(employeeDTO.getBranchId());
        if (!optionalBranch.isPresent()) return new ApiResponse("Bunday Filial mavjud emas.",false);
        employee.setBranch(optionalBranch.get());
        employeeRepository.save(employee);
        return new ApiResponse("save",true);
    }

    public ApiResponse deleteEmployeeService(UUID id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) return new ApiResponse("Bunday xodim mavjud emas.",false);
        employeeRepository.deleteById(id);
        return new ApiResponse("xodim o'chirildi.",true);
    }

}
