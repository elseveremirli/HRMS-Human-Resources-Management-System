package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    Result addCv(Cv cv);

    DataResult<List<Cv>> getAll();

    DataResult<Cv> getById(int id);

    DataResult<List<Cv>> getByCandidateId(int candidateId);
}
