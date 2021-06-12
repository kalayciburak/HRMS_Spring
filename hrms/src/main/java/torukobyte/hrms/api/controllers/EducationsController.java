package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.EducationService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Education;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
    private final EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getEducations")
    public DataResult<List<Education>> getEducations() {
        return this.educationService.getAllEducations();
    }

    @GetMapping("/getEducationsByCvId")
    public DataResult<List<Education>> getEducationsByCvId(@RequestParam int cvId) {
        return this.educationService.getEducationsByCvId(cvId);
    }

    @PostMapping("/addEducation")
    public Result addEducation(@RequestBody Education education) {
        return this.educationService.addEducation(education);
    }
}
