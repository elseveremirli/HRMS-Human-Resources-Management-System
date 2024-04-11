package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.HrmsEmployeeDao;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HrmsEmployeeManager implements HrmsEmployeeService {
    private  final HrmsEmployeeDao hrmsEmployeeDao;
    private final BCryptPasswordEncoder passwordEncoder;

    public HrmsEmployeeManager(HrmsEmployeeDao hrmsEmployeeDao, BCryptPasswordEncoder passwordEncoder) {
        this.hrmsEmployeeDao = hrmsEmployeeDao;
        this.passwordEncoder = passwordEncoder;
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
        HrmsEmployee hrmsEmployee = HrmsEmployee.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .username(employee.getUsername())
                .password(passwordEncoder.encode(employee.getPassword()))
                .accountNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .isCredentialsNonExpired(true)
                .authorities(null)
                .build();

        hrmsEmployeeDao.save(hrmsEmployee);
        return new SuccessResult("Saved");
    }

    @Override
    public Optional<HrmsEmployee> findByUsername(String username) {
        return hrmsEmployeeDao.findByUsername(username);
    }


}
