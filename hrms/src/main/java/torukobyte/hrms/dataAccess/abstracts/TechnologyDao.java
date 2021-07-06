package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Technology;

import javax.transaction.Transactional;
import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    List<Technology> getTechnologieByCurriculaVitaeId(int id);

    @Transactional
    void deleteTechnologyById(int id);
}
