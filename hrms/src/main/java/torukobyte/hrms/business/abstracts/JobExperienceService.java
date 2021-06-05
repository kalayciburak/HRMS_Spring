package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperience jobExperience);

    DataResult<List<JobExperience>> findAllSorted(int id);
}
