package kodlama.io.hrms.api.controllers;


import kodlama.io.hrms.business.abstracts.HrmsAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrmsAuth")
public class HrmsAuthController {
    private HrmsAuthService hrmsAuthService;
    @Autowired
    public HrmsAuthController(HrmsAuthService hrmsAuthService){
        this.hrmsAuthService=hrmsAuthService;
    }

    @GetMapping("/getall")
    public  DataResult<List<HrmsAuth>> getAll(){
        return hrmsAuthService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<HrmsAuth> getById(@RequestParam int id){
        return hrmsAuthService.getById(id);
    }

    @PostMapping("/add")
    public Result add(HrmsAuth hrmsAuth){
        return hrmsAuthService.save(hrmsAuth);
    }



}
