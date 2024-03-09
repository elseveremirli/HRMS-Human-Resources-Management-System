package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.HrmsAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsAuthDao extends JpaRepository<HrmsAuth,Integer> {
    HrmsAuth findById(int id);
}
