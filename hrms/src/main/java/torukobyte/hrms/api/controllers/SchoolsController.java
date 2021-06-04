package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.SchoolService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.School;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getSchools")
    public DataResult<List<School>> getSchools() {
        return this.schoolService.getAllSchool();
    }

    @PostMapping("/addSchool")
    public Result addJobSeeker(@RequestBody School school) {
        return this.schoolService.addSchool(school);
    }
}
