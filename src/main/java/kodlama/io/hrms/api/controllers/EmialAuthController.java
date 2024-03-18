package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.EmailAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.EMailAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> add(@Valid  @RequestBody EMailAuth emailAuth) {
        this.emailAuthService.add(emailAuth);
        return ResponseEntity.ok("Eklendi");
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
