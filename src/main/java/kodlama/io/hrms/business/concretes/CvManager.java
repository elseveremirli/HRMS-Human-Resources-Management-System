package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public Result addCv(Cv cv) {
        cvDao.save(cv);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public DataResult<Cv> getById(int id) {
        return new SuccessDataResult<Cv>(cvDao.findById(id));
    }

    @Override
    public DataResult<List<Cv>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Cv>>(cvDao.getByCandidateId(candidateId));
    }
}
