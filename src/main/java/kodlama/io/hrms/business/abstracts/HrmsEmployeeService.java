package kodlama.io.hrms.business.abstracts;


import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;

import java.util.List;

public interface HrmsEmployeeService {
        DataResult<List<HrmsEmployee>> getAll();

        DataResult<HrmsEmployee> getHrmsEmployeeById(int id);

        Result saveHrmsEmployee(HrmsEmployee employee);
    }

