package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result addSchool(School school);
    DataResult<List<School>> getAll();
}
