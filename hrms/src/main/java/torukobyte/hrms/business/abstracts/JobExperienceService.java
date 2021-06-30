package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobExperience;
import torukobyte.hrms.entities.dtos.addDtos.JobExperienceAddDto;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperienceAddDto jobExperience);

    DataResult<List<JobExperience>> getJobExperienceByCvId(int id);
}
