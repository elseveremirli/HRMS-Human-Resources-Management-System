package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobAdvertismentService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/JobAdvertismentController")
public class JobAdvertismentController {
    private JobAdvertismentService jobAdvertismentService;
    @Autowired
    public JobAdvertismentController(JobAdvertismentService jobAdvertismentService){
        this.jobAdvertismentService=jobAdvertismentService;
    }
    Result save(JobAdvertisement jobAdvertisement){
        return jobAdvertismentService.save(jobAdvertisement);

    };
    Result setJobAdvertisementStatus(int id, boolean newStatus){
        return jobAdvertismentService.setJobAdvertisementStatus(id,newStatus);
    };
    DataResult<List<JobAdvertisement>> findByIsOpen(){
        return jobAdvertismentService.findByIsOpen();
    };
    DataResult<List<JobAdvertisement>> findByIsOpenAndDate(){
        return jobAdvertismentService.findByIsOpenAndDate();
    };
    DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(String companyName){
        return jobAdvertismentService.findByEmployerCompanyNameAndIsOpen(companyName);
    };
}
