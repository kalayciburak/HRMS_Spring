package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Technologie;

import java.util.List;

public interface TechnologieService {
    Result addProgrammingLanguage(Technologie pl);

    DataResult<List<Technologie>> getAllProgrammingLanguage();
}
