package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;
import torukobyte.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

import java.util.List;

public interface JobSeekerLanguageService {
    Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);

    DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByCurriculaVitaeId(int id);
}
