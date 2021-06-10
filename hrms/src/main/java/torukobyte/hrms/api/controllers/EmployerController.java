package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.EmployerService;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Employer;

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

    @GetMapping("/getemployers")
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

    @PostMapping("/addemployer")
    public Result addEmployer(@RequestBody Employer employer) {
        return this.employerService.addEmployer(employer);
    }

    @PostMapping("/updateIsActive")
    public Result deactiveJobAdvert(@RequestParam("job_adverts_id") int jobAdvertId) {
        return this.jobAdvertService.deactiveJobAdvert(jobAdvertId);
    }
}