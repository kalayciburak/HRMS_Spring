package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobPositionService;
import torukobyte.hrms.dataAccess.abstracts.JobPositionDao;
import torukobyte.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getPositions() {
        return this.jobPositionDao.findAll();
    }
}
