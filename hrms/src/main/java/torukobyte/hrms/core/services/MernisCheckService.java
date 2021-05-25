package torukobyte.hrms.core.services;

import torukobyte.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
    boolean isMernis(JobSeeker jobSeeker);
}
