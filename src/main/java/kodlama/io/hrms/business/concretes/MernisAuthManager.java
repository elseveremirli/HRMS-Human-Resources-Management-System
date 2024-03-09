package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.MernisAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.MernisAuthDao;
import kodlama.io.hrms.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MernisAuthManager implements MernisAuthService {
    private MernisAuthDao mernisAuthDao;

    @Autowired
    public MernisAuthManager(MernisAuthDao mernisAuthDao) {
        this.mernisAuthDao = mernisAuthDao;
    }

    @Override
    public DataResult<List<MernisAuth>> getAll() {
        return new SuccessDataResult<List<MernisAuth>>(mernisAuthDao.findAll(), "Mernis auths are listed");
    }

    @Override
    public DataResult<MernisAuth> getById(int id) {
        return new SuccessDataResult<MernisAuth>(mernisAuthDao.findById(id));
    }

    @Override
    public Result add(MernisAuth auth) {
        mernisAuthDao.save(auth);
        return new SuccessResult("Auth is registered");
    }
}
