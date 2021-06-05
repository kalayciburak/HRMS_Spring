package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.TechnologieService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Technologie;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class TechnologiesController {

    private final TechnologieService technologieService;

    @Autowired
    public TechnologiesController(TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @GetMapping("/getProgrammingLanguages")
    public DataResult<List<Technologie>> getProgrammingLanguages() {
        return this.technologieService.getAllProgrammingLanguage();
    }

    @PostMapping("/addProgrammingLanguage")
    public Result addProgrammingLanguage(@RequestBody Technologie pl) {
        return this.technologieService.addProgrammingLanguage(pl);
    }
}
