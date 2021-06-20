package torukobyte.hrms.mernisValidator;

import org.springframework.stereotype.Service;
import torukobyte.hrms.entities.concretes.JobSeeker;

@Service
public class MernisValidatorManager {

    public boolean isMernis(JobSeeker jobSeeker) {
        return jobSeeker.getIdentityNumber().length() == 11;
    }
}
