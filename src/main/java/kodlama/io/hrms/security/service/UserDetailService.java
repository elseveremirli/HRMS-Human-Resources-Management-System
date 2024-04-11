package kodlama.io.hrms.security.service;

import jakarta.persistence.EntityNotFoundException;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    private final HrmsEmployeeService hrmsEmployeeService;
    private final EmployerService employerService;

    public UserDetailService(HrmsEmployeeService hrmsEmployeeService, EmployerService employerService) {
        this.hrmsEmployeeService = hrmsEmployeeService;
        this.employerService = employerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<HrmsEmployee> hrmsEmployee = this.hrmsEmployeeService.findByUsername(username);
        Optional<Employer> employer = this.employerService.findByUsername(username);

        if(hrmsEmployee.isPresent()){
            return hrmsEmployee.orElseThrow(EntityNotFoundException::new);
        }
        return employer.orElseThrow(EntityNotFoundException::new);
    }
}
