package kodlama.io.hrms.security.service;


import jakarta.persistence.EntityNotFoundException;
import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HrmsEmployeeDetailServiceImpl implements UserDetailsService  {

    private final HrmsEmployeeService hrmsEmployeeService;


    public HrmsEmployeeDetailServiceImpl(HrmsEmployeeService hrmsEmployeeService) {
        this.hrmsEmployeeService = hrmsEmployeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<HrmsEmployee> hrmsEmployee = this.hrmsEmployeeService.findByUsername(username);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return hrmsEmployee.orElseThrow(EntityNotFoundException::new);
    }
}
