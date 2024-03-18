package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobAdvertismentService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
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
@RequestMapping("/api/JobAdvertismentController/")
public class JobAdvertismentController {
    private JobAdvertismentService jobAdvertismentService;
    @Autowired
    public JobAdvertismentController(JobAdvertismentService jobAdvertismentService){
        this.jobAdvertismentService=jobAdvertismentService;
    }

    @PostMapping("add")
    public ResponseEntity<?> save(@RequestBody @Valid JobAdvertisement jobAdvertisement){
         jobAdvertismentService.save(jobAdvertisement);
        return ResponseEntity.ok("Eklendi");
    };

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

    @GetMapping("setJobAdvertisementStatus")
    public Result setJobAdvertisementStatus(@RequestParam int id,@RequestParam boolean newStatus){
        return jobAdvertismentService.setJobAdvertisementStatus(id,newStatus);
    };
    @GetMapping("findByIsOpen")
    public DataResult<List<JobAdvertisement>> findByIsOpen(){
        return jobAdvertismentService.findByIsOpen();
    };
    @GetMapping("findByIsOpenAndDate")
    public DataResult<List<JobAdvertisement>> findByIsOpenAndDate(){
        return jobAdvertismentService.findByIsOpenAndDate();
    };
    @GetMapping("findByEmployerCompanyNameAndIsOpen")
    public DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(@RequestParam String companyName){
        return jobAdvertismentService.findByEmployerCompanyNameAndIsOpen(companyName);
    };
}
