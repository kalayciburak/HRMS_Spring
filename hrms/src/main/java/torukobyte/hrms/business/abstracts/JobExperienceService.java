package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
    Result addJobExperience(JobExperience jobExperience);
}
