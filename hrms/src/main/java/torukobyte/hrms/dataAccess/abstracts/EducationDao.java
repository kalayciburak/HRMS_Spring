package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {
    List<Education> getEducationEndDateByCurriculaVitaeId(int id, Sort sort);
}
