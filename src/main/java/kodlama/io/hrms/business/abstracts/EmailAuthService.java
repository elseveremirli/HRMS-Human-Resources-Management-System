package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.EMailAuth;

import java.util.List;

public interface EmailAuthService {
    DataResult<List<EMailAuth>> getAll();

    DataResult<List<EMailAuth>> getById(int id);

    Result add(EMailAuth mail);

}
