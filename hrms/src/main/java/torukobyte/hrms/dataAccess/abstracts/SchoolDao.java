package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
