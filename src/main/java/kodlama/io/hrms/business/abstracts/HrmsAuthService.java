package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsAuth;

import java.util.List;

public interface HrmsAuthService {
    DataResult<List<HrmsAuth>> getAll();

    DataResult<HrmsAuth> getById(int id);

    Result save(HrmsAuth hmrsAuth);
}
