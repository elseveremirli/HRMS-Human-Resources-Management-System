package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.result.*;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.EMailAuthDao;
import kodlama.io.hrms.dataAccess.abstracts.MernisAuthDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.EMailAuth;
import kodlama.io.hrms.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private EMailAuthDao eMailAuthDao;
    private MernisAuthDao mernisAuthDao;
    @Autowired
    public CandidateManager(CandidateDao candidateDao, EMailAuthDao eMailAuthDao, MernisAuthDao mernisAuthDao) {
        this.candidateDao = candidateDao;
        this.eMailAuthDao = eMailAuthDao;
        this.mernisAuthDao = mernisAuthDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult(candidateDao.findAll(),"Candidates are listed");
    }

    @Override
    public Result addCandidate(Candidate candidate) {
        Result password = isPasswordMatch(candidate.getPassword(), candidate.getRePassword());
        if (!password.isSuccess()) {
            return new ErrorResult("Worong password");
        }
        Result eMail = isEmailAlreadyRegistered(candidate.getEMail());
        if (eMail.isSuccess()) {
            return new ErrorResult("Email already registered");
        }
        Result nationalIdResult = isNationalIdAlreadyRegistered(candidate.getNationalId());
        if (nationalIdResult.isSuccess()){
            return new ErrorResult("National Id is already registered");
        }
        Date date = new Date(System.currentTimeMillis());

        createEmailAuth(candidate, date);
        createMernisAuth(candidate, date);
        Result mernisResult = isMernisAuthVerified(candidate.getMernisAuth());
        Result emailAuthResult = isEMailAuthVerified(candidate.getEMailAuth());
        if(mernisResult.isSuccess()){
            if (emailAuthResult.isSuccess()){
                candidateDao.save(candidate);
                return new SuccessResult("Registered successfully");
            }
            return new ErrorResult(emailAuthResult.getMessage());
        }
        return new ErrorResult(mernisResult.getMessage());
    }



    private Result isPasswordMatch(String password, String rePassword){
        if(Objects.equals(password,rePassword)){
            return new SuccessResult("True");
        }
        return new ErrorResult("False");
    }

    private Result isEmailAlreadyRegistered(String email){
        List<Candidate> result = candidateDao.findByeMailIgnoreCase(email);
        if (result.size() != 0) {
            return new SuccessResult("Email already registered");
        }
        return new ErrorResult("");
    }
    Result isNationalIdAlreadyRegistered(String nationalId) {
        List<Candidate> result = candidateDao.findByNationalId(nationalId);
        if (result.size() != 0)
            return new SuccessResult("National Id already registered");
        return new ErrorResult("");
    }
     void createEmailAuth(Candidate candidate,Date date){
         EMailAuth eMailAuth = new EMailAuth(0,true,date);
         candidate.setEMailAuth(candidate.getId());
         eMailAuthDao.save(eMailAuth);
     }
    void createMernisAuth(Candidate candidate, Date date) {
        MernisAuth newMernisAuth = new MernisAuth(0, true, date);
        candidate.setMernisAuth(newMernisAuth.getId());
        mernisAuthDao.save(newMernisAuth);
    }
    Result isMernisAuthVerified(int id) {
        MernisAuth mernisAuth = mernisAuthDao.findById(id);
        if (mernisAuth.isVerified()) {
            return new SuccessResult("");
        }
        return new ErrorResult("Mernis auth not verified");
    }

    Result isEMailAuthVerified(int id) {
        EMailAuth emailAuth = eMailAuthDao.findById(id);
        if (emailAuth.isVerified()) {
            return new SuccessResult("");
        }
        return new ErrorResult("email auth not verified");
    }
}
