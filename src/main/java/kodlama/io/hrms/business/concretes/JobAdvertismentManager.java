package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobAdvertismentService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertismentManager implements JobAdvertismentService {
    private JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    public JobAdvertismentManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao=jobAdvertisementDao;
    }

    @Override
    public Result save(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Saved");
    }

    @Override
    public Result setJobAdvertisementStatus(int id, boolean newStatus) {
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(id);
        jobAdvertisement.setOpen(newStatus);
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Seted");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsOpen() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsOpen(true));
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsOpenAndDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsOpen(true));
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByEmployerCompanyNameAndIsOpen(companyName,true));
    }


}
