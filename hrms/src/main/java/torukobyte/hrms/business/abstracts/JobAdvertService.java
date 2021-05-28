package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    DataResult<List<JobAdvert>> getJobAdverts();

    Result addJobAdvert(JobAdvert jobAdvert);
}
