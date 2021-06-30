package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Technology;
import torukobyte.hrms.entities.dtos.addDtos.TechnologyAddDto;

import java.util.List;

public interface TechnologieService {
    Result addProgrammingLanguage(TechnologyAddDto pl);

    DataResult<List<Technology>> getAllProgrammingLanguage();
}
