package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.HrmsEmployeeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.HrmsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/hmrsEmployee")
public class HrmsEmployeeController {
    private final HrmsEmployeeService hrmsEmployeeService;
    public HrmsEmployeeController(HrmsEmployeeService hrmsEmployeeService) {
        this.hrmsEmployeeService = hrmsEmployeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<HrmsEmployee>> getAll() {
        return this.hrmsEmployeeService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Result getById(@PathVariable("id") int id) {
        return this.hrmsEmployeeService.getHrmsEmployeeById(id);
    }
    @GetMapping("/getByUsername/{username}")
    public Optional<HrmsEmployee> getByUsername(@PathVariable String username){
        return hrmsEmployeeService.findByUsername(username);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody HrmsEmployee employee) {
        this.hrmsEmployeeService.saveHrmsEmployee(employee);
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
