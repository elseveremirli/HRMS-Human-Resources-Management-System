package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result addCandidate(Candidate candidate);
}
