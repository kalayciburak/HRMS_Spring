package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.CurriculaVitae;

public interface CurriculaVitaeDao extends JpaRepository<CurriculaVitae, Integer> {
//    @Query("Select new torukobyte.hrms.entities.dtos.JobseekerWithCurriculaVitaeDto(j.id,j.firstName,j.lastName,cv.coverLetter," +
//            "je.companyName,je.positionName,je.startDate,je.endDate,sc.schoolName," +
//            "dp.departmentName,edu.startDate,edu.endDate,jlan.languageDegree,lan.languageName," +
//            "pl.plName,sm.githubUsername,sm.linkedinUsername,pic.pictureUrl)from CurriculaVitae cv" +
//            " inner join cv.jobSeeker j inner join cv.jobExperiences je inner join cv.educations edu" +
//            " inner join edu.school sc inner join edu.department dp inner join cv.jobSeekerLanguages jlan" +
//            " inner join jlan.language lan inner join cv.programmingLanguages pl inner join cv.socialMedia sm" +
//            " inner join cv.pictures pic where j.id =:id")
//    List<JobseekerWithCurriculaVitaeDto> getJobSeekerWithCurriculaVitae(int id);

    CurriculaVitae findByJobSeekerId(int id);
}
