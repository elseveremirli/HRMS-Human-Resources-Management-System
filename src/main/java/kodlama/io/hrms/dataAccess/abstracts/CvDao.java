package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv,Integer> {
    Cv findById(int id);
    List<Cv> getByCandidateId(int candidateId);

}
