package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
