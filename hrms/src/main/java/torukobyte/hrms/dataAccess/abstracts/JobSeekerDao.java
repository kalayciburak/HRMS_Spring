package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.JobSeeker;

import javax.transaction.Transactional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker getJobSeekerById(int id);

    @Transactional
    void deleteJobSeekerById(int id);
}