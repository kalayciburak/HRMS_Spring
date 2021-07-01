package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Technology;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    List<Technology> getTechnologieByCurriculaVitaeId(int id);
}
