package kodlama.io.hrms.security.service;

import jakarta.persistence.EntityNotFoundException;
import kodlama.io.hrms.business.abstracts.EmployeeService;
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
public class EmpolerDetailServiceImpl implements UserDetailsService {

    private final EmployerService employerService;

    public EmpolerDetailServiceImpl(EmployerService employerService) {
        this.employerService = employerService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employer> employer = this.employerService.findByUsername(username);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return employer.orElseThrow(EntityNotFoundException::new);
    }

}
