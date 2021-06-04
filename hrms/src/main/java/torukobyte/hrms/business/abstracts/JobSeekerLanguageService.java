package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageService {
    Result addJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage);
}
