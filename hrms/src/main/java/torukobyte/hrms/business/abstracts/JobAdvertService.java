package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    DataResult<List<JobAdvert>> getJobAdverts();

    DataResult<List<JobAdvert>> getSortedJobAdverts();

    DataResult<List<JobAdvert>> getActiveJobAdverts();

    DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName);

    DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc);

    DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo, int pageSize);

    DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize);

    DataResult<JobAdvert> getJobAdvertById(int jobAdvertId);

    Result changeIsActive(boolean active, int jobAdvertId);

    Result changeIsConfirmed(boolean confirm, int jobAdvertId);

    Result addJobAdvert(JobAdvert jobAdvert);

    Result deleteJobAdvertById(int jobAdvertId);

}
