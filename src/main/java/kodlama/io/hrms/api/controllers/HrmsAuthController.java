package kodlama.io.hrms.api.controllers;


import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.HrmsAuthService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsAuth;
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
    public ResponseEntity<?> add(@Valid @RequestBody HrmsAuth hrmsAuth){
         hrmsAuthService.save(hrmsAuth);
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
