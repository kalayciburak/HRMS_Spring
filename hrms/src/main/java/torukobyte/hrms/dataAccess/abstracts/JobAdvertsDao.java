package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.JobAdvert;

public interface JobAdvertsDao extends JpaRepository<JobAdvert, Integer> {


}
