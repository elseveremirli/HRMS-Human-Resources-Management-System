package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EMailAuthDao;
import kodlama.io.hrms.entities.concretes.EMailAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailAuthManager implements EmailAuthService {
    private EMailAuthDao eMailAuthDao;

    @Autowired
    public EmailAuthManager(EMailAuthDao eMailAuthDao) {
        this.eMailAuthDao = eMailAuthDao;
    }


    @Override
    public DataResult<List<EMailAuth>> getAll() {
        return new SuccessDataResult(eMailAuthDao.findAll(),"Email auths are listed");
    }

    @Override
    public DataResult<List<EMailAuth>> getById(int id) {
        return new SuccessDataResult(eMailAuthDao.findById(id));
    }

    @Override
    public Result add(EMailAuth mail) {
        eMailAuthDao.save(mail);
        return new SuccessResult("Email auth is added");
    }
}
