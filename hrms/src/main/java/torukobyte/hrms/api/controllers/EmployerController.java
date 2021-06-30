package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.business.abstracts.EmployerService;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Employer;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
    private final EmployerService employerService;

    private final JobAdvertService jobAdvertService;


    @Autowired
    public EmployerController(EmployerService employerService, JobAdvertService jobAdvertService) {
        this.employerService = employerService;
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getEmployers")
    public DataResult<List<Employer>> getEmployers() {
        return this.employerService.getEmployers();
    }

    @GetMapping("/getByEmployerId")
    public DataResult<Employer> getEmployerById(int employerId) {
        return this.employerService.getEmployerById(employerId);
    }

    @DeleteMapping("/deleteEmployerById")
    public Result deleteEmployerById(@RequestParam int employerId) {
        return this.employerService.deleteEmployerById(employerId);
    }

    @PostMapping("/addEmployer")
    public Result addEmployer(@RequestBody Employer employer) {
        return this.employerService.addEmployer(employer);
    }

    @PutMapping("/updateEmployer")
    public Result updateEmployer(@RequestBody Employer employer) {
        return this.employerService.updateEmployer(employer);
    }


    @PostMapping("/changeIsActive")
    public Result changeIsActive(@RequestParam boolean active, int jobAdvertId) {
        return this.jobAdvertService.changeIsActive(active, jobAdvertId);
    }

    @PostMapping("/addPicture")
    public Result addPicture(int employerId, MultipartFile file) throws IOException {
        return this.employerService.uploadPicture(employerId, file);
    }
}