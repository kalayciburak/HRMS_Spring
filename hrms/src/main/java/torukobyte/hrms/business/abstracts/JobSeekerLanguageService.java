package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

public interface JobSeekerLanguageService {
    Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);
}
