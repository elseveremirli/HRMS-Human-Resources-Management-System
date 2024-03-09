package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.result.*;
import kodlama.io.hrms.dataAccess.abstracts.EMailAuthDao;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.HrmsAuthDao;
import kodlama.io.hrms.entities.concretes.EMailAuth;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.HrmsAuth;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private final EMailAuthDao eMailAuthDao;
    private final HrmsAuthDao hrmsAuthDao;

    public  EmployerManager(EmployerDao employerDao,
                            EMailAuthDao eMailAuthDao,
                            HrmsAuthDao hrmsAuthDao){
        this.employerDao=employerDao;
        this.eMailAuthDao = eMailAuthDao;
        this.hrmsAuthDao = hrmsAuthDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employers are listed.");
    }

    @Override
    public Result addEmployer(Employer employer) {
        Result password = isPasswordMatch(employer.getPassword(),employer.getRePassword());
        if (!password.isSuccess()){
            return new ErrorResult("Password wrong");
        }
        Result email = isEmailAlreadyRegistered(employer.getEMail());
        if(!email.isSuccess()){
            return new ErrorResult(email.getMessage());
        }
        Date date = new Date(System.currentTimeMillis());
        createHrmsAuth(employer,date);
        createEmailAuth(employer,date);

        employerDao.save(employer);
        return new SuccessResult("Employer added");
    }

    private Result isPasswordMatch(String password, String rePassword){
        if(Objects.equals(password,rePassword)){
            return new SuccessResult("True");
        }
        return new ErrorResult("False");
    }
    private Result isEmailAlreadyRegistered(String email){
        List<Employer> result = employerDao.findByeMailIgnoreCase(email);
        if(result.size() == 0){
            return new SuccessResult("");
        }
        return new ErrorResult("");
    }

    void createEmailAuth(Employer employer,Date date){
        EMailAuth eMailAuth = new EMailAuth(0,true,date);
        eMailAuthDao.save(eMailAuth);
        employer.setEMailAuth(eMailAuth.getId());
    }
    void createHrmsAuth(Employer employer,Date date){
        HrmsAuth hrmsAuth = new HrmsAuth(0,date,1,true);
        hrmsAuthDao.save(hrmsAuth);
        employer.setHrmsAuth(hrmsAuth.getId());
    }
}
