package torukobyte.hrms.core.adapters;

import org.springframework.stereotype.Service;
import torukobyte.hrms.core.services.MernisCheckService;
import torukobyte.hrms.entities.concretes.JobSeeker;
import torukobyte.hrms.mernisValidator.MernisValidatorManager;

@Service
public class MernisValidatorManagerAdapter implements MernisCheckService {
    private final MernisValidatorManager mernisValidatorManager;

    public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorManager) {
        this.mernisValidatorManager = mernisValidatorManager;
    }

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return this.mernisValidatorManager.isMernis(jobSeeker);
    }
}
