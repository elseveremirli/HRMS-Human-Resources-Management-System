package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    List<Employer> findByeMailIgnoreCase(String email);
    Optional<Employer> findByUsername(String username);
}
