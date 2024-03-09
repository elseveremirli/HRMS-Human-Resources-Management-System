package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.HrmsAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.HrmsAuthDao;
import kodlama.io.hrms.entities.concretes.HrmsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HrmsAuthManager implements HrmsAuthService {
    private HrmsAuthDao hrmsAuthDao;
    @Autowired
    public HrmsAuthManager(HrmsAuthDao hrmsAuthDao){
        this.hrmsAuthDao=hrmsAuthDao;
    }
    @Override
    public DataResult<List<HrmsAuth>> getAll() {
        return new SuccessDataResult<List<HrmsAuth>>(hrmsAuthDao.findAll(),"Hrms are listed");
    }

    @Override
    public DataResult<HrmsAuth> getById(int id) {
        return new SuccessDataResult<HrmsAuth>(hrmsAuthDao.findById(id));
    }

    @Override
    public Result save(HrmsAuth hrmsAuth) {
        hrmsAuthDao.save(hrmsAuth);
        return new SuccessResult("Saved");
    }
}
