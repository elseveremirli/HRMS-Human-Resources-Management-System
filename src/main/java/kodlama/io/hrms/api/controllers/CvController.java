package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Cv;
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
@RequestMapping("/api/cv/")
public class CvController {
    private CvService cvService;
    @Autowired
    public CvController(CvService cvService){
        this.cvService=cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Cv cv) {
        cvService.addCv(cv);
        return ResponseEntity.ok("Added");
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

    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Cv> getById(@RequestParam int id) {
        return this.cvService.getById(id);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<List<Cv>> getByCandidateId(@RequestParam int candidateId) {
        return this.cvService.getByCandidateId(candidateId);
    }
}
