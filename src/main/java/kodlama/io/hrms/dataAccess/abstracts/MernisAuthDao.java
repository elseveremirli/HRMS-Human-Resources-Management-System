package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.MernisAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MernisAuthDao extends JpaRepository<MernisAuth,Integer> {
    MernisAuth findById(int id);
}
