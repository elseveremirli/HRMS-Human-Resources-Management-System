package kodlama.io.hrms.dataAccess.abstracts;


import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeDao extends JpaRepository<HrmsEmployee,Integer> {
    HrmsEmployee findById(int id);
}
