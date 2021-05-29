package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    DataResult<List<JobAdvert>> getJobAdverts();

    DataResult<List<JobAdvert>> getActiveJobAdverts();

    DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName);

    DataResult<List<JobAdvert>> findAllByIsActiveTrue();

    Result deactiveJobAdvert(int jobAdvertId);

    Result addJobAdvert(JobAdvert jobAdvert);

}
