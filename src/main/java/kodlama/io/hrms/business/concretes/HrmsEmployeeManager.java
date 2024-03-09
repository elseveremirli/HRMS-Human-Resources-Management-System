package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.HrmsEmployeeDao;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrmsEmployeeManager implements HrmsEmployeeService {
    private HrmsEmployeeDao hrmsEmployeeDao;
    @Autowired
    public HrmsEmployeeManager(HrmsEmployeeDao hrmsEmployeeDao){
        this.hrmsEmployeeDao=hrmsEmployeeDao;
    }
    @Override
    public DataResult<List<HrmsEmployee>> getAll() {
        return new SuccessDataResult<List<HrmsEmployee>>(hrmsEmployeeDao.findAll(),"Employee are listed");
    }

    @Override
    public DataResult<HrmsEmployee> getHrmsEmployeeById(int id) {
        return new SuccessDataResult<HrmsEmployee>(hrmsEmployeeDao.findById(id));
    }

    @Override
    public Result saveHrmsEmployee(HrmsEmployee employee) {
        hrmsEmployeeDao.save(employee);
        return new SuccessResult("Saved");
    }
}
