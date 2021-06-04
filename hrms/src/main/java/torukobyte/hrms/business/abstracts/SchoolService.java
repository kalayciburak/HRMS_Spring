package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result addSchool(School school);

    DataResult<List<School>> getAllSchool();
}
