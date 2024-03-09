package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAllCandidates() {
        return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result addCandidate(@RequestBody Candidate candidate) {
        return this.candidateService.addCandidate(candidate);
    }
}
