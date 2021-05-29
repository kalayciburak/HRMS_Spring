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
        if ((long) this.jobPositionDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Success: Pozisyonalar listelendi!");
        }
        return new WarningDataResult<>(this.jobPositionDao.findAll(), "Warning: Herhangi bir pozisyon bulunamadı!");
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