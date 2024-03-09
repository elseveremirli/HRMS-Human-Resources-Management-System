package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.MernisAuth;

import java.util.List;

public interface MernisAuthService {
    DataResult<List<MernisAuth>> getAll();

    DataResult<MernisAuth> getById(int id);

    Result add(MernisAuth auth);
}
