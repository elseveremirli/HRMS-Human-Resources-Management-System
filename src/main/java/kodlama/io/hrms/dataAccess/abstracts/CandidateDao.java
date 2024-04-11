package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    List<Candidate> findByeMailIgnoreCase(String email);

    List<Candidate> findByNationalId(String nationalId);
    Optional<Candidate> findByUsername(String username);
}
