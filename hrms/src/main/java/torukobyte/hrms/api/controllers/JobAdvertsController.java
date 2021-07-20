package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobAdvert;
import torukobyte.hrms.entities.dtos.addDtos.JobAdvertAddDto;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getJobAdverts")
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return this.jobAdvertService.getJobAdverts();
    }

    @GetMapping("/getSortedJobAdverts")
    public DataResult<List<JobAdvert>> getSortedJobAdverts() {
        return this.jobAdvertService.getSortedJobAdverts();
    }

    @GetMapping("/getActiveJobAdverts")
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        return this.jobAdvertService.getActiveJobAdverts();
    }

    @GetMapping("/getJobAdvertByCompanyName")
    public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
        return this.jobAdvertService.getJobAdvertByCompanyName(companyName);
    }

    @GetMapping("/getActiveJobAdvertsSorted")
    public DataResult<List<JobAdvert>> findAllByIsActiveTrueSorted(@RequestParam boolean isDesc) {
        return this.jobAdvertService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrue")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
    }


    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(
            @RequestParam int pageNo,
            int pageSize) {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(
            @RequestParam int pageNo,
            int pageSize) {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        return this.jobAdvertService.getJobAdvertById(jobAdvertId);
    }

    @DeleteMapping("/deleteJobAdvertById")
    public Result deleteJobAdvertById(@RequestParam int jobAdvertId) {
        return this.jobAdvertService.deleteJobAdvertById(jobAdvertId);
    }

    @PostMapping("/addJobadvert")
    public Result addJobAdverts(@RequestBody JobAdvertAddDto jobAdvert) {
        return this.jobAdvertService.addJobAdvert(jobAdvert);
    }

}
