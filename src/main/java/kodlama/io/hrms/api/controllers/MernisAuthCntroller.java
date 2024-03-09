package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.MernisAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/mernis")
public class MernisAuthCntroller {
    private MernisAuthService mernisAuthService;

    @Autowired
    public MernisAuthCntroller(MernisAuthService mernisAuthService) {
        this.mernisAuthService = mernisAuthService;
    }

    @GetMapping("/getall")
    public DataResult<List<MernisAuth>> getAll() {
        return this.mernisAuthService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<MernisAuth> getByid(@RequestParam int id) {
        return this.mernisAuthService.getById(id);
    }

    @PostMapping("/add")
    public Result addMernisAuth(@RequestBody MernisAuth mernisAuth) {
        return this.mernisAuthService.add(mernisAuth);
    }
}
