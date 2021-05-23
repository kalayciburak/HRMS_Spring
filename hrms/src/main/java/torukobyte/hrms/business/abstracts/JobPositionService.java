package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getPositions();
}
