package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
}
