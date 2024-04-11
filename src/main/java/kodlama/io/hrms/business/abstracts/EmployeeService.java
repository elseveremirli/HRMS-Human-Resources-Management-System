package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.HrmsEmployee;

import java.util.Optional;

public interface EmployeeService {

    public Optional<HrmsEmployee> findByUsername(String username);

}
