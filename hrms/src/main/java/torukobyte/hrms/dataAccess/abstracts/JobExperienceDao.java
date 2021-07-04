package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.JobExperience;

import javax.transaction.Transactional;
import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> getJobExperienceEndDateByCurriculaVitaeId(int id, Sort sort);

    @Transactional
    void deleteJobExperienceById(int id);

}
