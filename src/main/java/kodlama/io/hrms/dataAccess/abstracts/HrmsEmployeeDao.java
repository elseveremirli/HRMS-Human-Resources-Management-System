package kodlama.io.hrms.dataAccess.abstracts;


import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HrmsEmployeeDao extends JpaRepository<HrmsEmployee,Integer> {
    HrmsEmployee findById(int id);
    Optional<HrmsEmployee> findByUsername(String username);
}
