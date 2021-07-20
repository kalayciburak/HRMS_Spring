package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torukobyte.hrms.business.abstracts.CityService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
    private final CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getCities")
    public DataResult<List<City>> getCities() {
        return this.cityService.getCities();
    }
}
