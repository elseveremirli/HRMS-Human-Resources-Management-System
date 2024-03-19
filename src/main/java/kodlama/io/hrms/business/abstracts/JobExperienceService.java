package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperience jobExperience);
    DataResult<List<JobExperience>> getAll();
}
