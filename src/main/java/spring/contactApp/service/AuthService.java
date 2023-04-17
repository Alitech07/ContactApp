package spring.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.contactApp.entity.Employee;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.LoginDto;
import spring.contactApp.repository.EmployeeRepository;
import spring.contactApp.security.JwtProvider;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    public ApiResponse loginUserService(LoginDto loginDto){
        try{
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(),
                    loginDto.getPassword()
            ));
            Employee employee = (Employee) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(loginDto.getUsername(), employee.getRole());
            return new ApiResponse("Token yaratildi.",true,token);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse("Login or password is incorrect.",false);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.getEmployeeByEmail(username);
        if (optionalEmployee.isPresent()) return optionalEmployee.get();
        throw new UsernameNotFoundException("Bunday user topilmadi");
    }
}
