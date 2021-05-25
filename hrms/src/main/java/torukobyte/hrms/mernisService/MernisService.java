package torukobyte.hrms.mernisService;

import org.springframework.stereotype.Service;
import torukobyte.hrms.core.services.MernisCheckService;
import torukobyte.hrms.entities.concretes.JobSeeker;

@Service
public class MernisService implements MernisCheckService {

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return jobSeeker.getIdentityNumber().length() == 11;
    }
}
