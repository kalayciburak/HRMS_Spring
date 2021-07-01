package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;

import java.util.List;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
    List<JobSeekerLanguage> getJobSeekerLanguageByCurriculaVitaeId(int id);
}
