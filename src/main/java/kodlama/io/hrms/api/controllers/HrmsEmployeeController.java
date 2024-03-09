package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hmrsEmployee")
public class HrmsEmployeeController {
    private HrmsEmployeeService hrmsEmployeeService;
    @Autowired
    public HrmsEmployeeController(HrmsEmployeeService hrmsEmployeeService) {
        this.hrmsEmployeeService = hrmsEmployeeService;
    }
    @GetMapping("/getAll")
    public DataResult<List<HrmsEmployee>> getAll() {
        return this.hrmsEmployeeService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(int id) {
        return this.hrmsEmployeeService.getHrmsEmployeeById(id);
    }

    @PostMapping("/add")
    public Result add(HrmsEmployee employee) {
        return this.hrmsEmployeeService.saveHrmsEmployee(employee);
    }

}
