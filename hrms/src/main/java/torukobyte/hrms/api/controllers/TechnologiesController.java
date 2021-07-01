package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.TechnologyService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Technology;
import torukobyte.hrms.entities.dtos.addDtos.TechnologyAddDto;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologiesController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologieService) {
        this.technologyService = technologieService;
    }

    @GetMapping("/getTechnologies")
    public DataResult<List<Technology>> getTechnologies() {
        return this.technologyService.getTechnologies();
    }

    @GetMapping("/getJobseekerLanguagesByCvId")
    public DataResult<List<Technology>> getTechnologieByCurriculaVitaeId(@RequestParam int cvId) {
        return this.technologyService.getTechnologieByCurriculaVitaeId(cvId);
    }

    @PostMapping("/addTechnology")
    public Result addTechnology(@RequestBody TechnologyAddDto pl) {
        return this.technologyService.addTechnology(pl);
    }
}
