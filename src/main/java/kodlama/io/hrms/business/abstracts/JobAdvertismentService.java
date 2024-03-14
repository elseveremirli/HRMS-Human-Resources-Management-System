package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertismentService {
    Result save(JobAdvertisement jobAdvertisement);
    Result setJobAdvertisementStatus(int id, boolean newStatus);
    DataResult<List<JobAdvertisement>> findByIsOpen();
    DataResult<List<JobAdvertisement>> findByIsOpenAndDate();
    DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(String companyName);
}
