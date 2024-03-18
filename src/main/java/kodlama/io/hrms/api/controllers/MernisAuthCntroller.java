package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.MernisAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.MernisAuth;
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
    public ResponseEntity<?> addMernisAuth(@Valid  @RequestBody MernisAuth mernisAuth) {
        this.mernisAuthService.add(mernisAuth);
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
