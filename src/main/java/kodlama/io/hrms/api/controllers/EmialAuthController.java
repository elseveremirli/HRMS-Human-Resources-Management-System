package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmailAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.EMailAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailauth")
public class EmialAuthController {
    private EmailAuthService emailAuthService;
    @Autowired
    public EmialAuthController(EmailAuthService emailAuthService) {
        this.emailAuthService = emailAuthService;
    }

    @GetMapping("/all")
    public DataResult<List<EMailAuth>> getAll() {
        return this.emailAuthService.getAll();
    }

    @GetMapping("/byid")
    public DataResult<EMailAuth> getById(@RequestParam int id) {
        return this.emailAuthService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EMailAuth emailAuth) {
        return this.emailAuthService.add(emailAuth);
    }
}
