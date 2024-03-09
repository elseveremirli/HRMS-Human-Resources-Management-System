package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.EMailAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMailAuthDao extends JpaRepository<EMailAuth,Integer> {
    EMailAuth findById(int id);
}

