package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Technology;

public interface TechnologieDao extends JpaRepository<Technology, Integer> {
}
