package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result addEmployer(Employer employer);
    Optional<Employer> findByUsername(String username);
}
