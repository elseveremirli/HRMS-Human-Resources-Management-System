package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    JobAdvertisement findById(int id);
    List<JobAdvertisement> findByIsOpen(boolean isOpen);
    List<JobAdvertisement> findByEmployerCompanyNameAndIsOpen(String employerCompanyName, boolean isOpen);

}
