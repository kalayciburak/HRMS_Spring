package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Education;
import torukobyte.hrms.entities.dtos.addDtos.EducationAddDto;

import java.util.List;

public interface EducationService {
    Result addEducation(EducationAddDto education);

    DataResult<List<Education>> getAllEducations();

    DataResult<List<Education>> getEducationsByCvId(int id);
}
