package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
}
