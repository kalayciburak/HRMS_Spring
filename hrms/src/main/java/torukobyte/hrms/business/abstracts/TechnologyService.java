package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Technology;
import torukobyte.hrms.entities.dtos.addDtos.TechnologyAddDto;
import torukobyte.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;

import java.util.List;

public interface TechnologyService {
    Result addTechnology(TechnologyAddDto pl);

    Result updateTechnology(TechnologyUpdateDto pl);

    Result deleteTechnologyById(int id);

    DataResult<List<Technology>> getTechnologies();

    DataResult<List<Technology>> getTechnologieByCurriculaVitaeId(int id);
}
