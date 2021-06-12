package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result addEducation(Education education);

    DataResult<List<Education>> getAllEducations();

    DataResult<List<Education>> getEducationsByCvId(int id);
}
