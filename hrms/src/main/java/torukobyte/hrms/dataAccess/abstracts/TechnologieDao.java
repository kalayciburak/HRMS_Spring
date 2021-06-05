package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Technologie;

public interface TechnologieDao extends JpaRepository<Technologie, Integer> {
}
