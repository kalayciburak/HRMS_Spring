package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobPositionService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.JobPositionDao;
import torukobyte.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getPositions() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Success: Pozisyonalar listelendi.");
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
        try {
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("Success: Pozisyon sisteme eklendi!");
        } catch (Exception e) {
            return new ErrorResult("Error: Sisteme kayıtlı böyle bir pozisyon mevcut!");
        }
    }
}