package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getCities();
}
