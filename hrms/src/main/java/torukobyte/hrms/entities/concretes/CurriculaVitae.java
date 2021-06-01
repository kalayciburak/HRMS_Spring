package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curricula_vitaes")
public class CurriculaVitae {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @ManyToOne()
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne()
    @JoinColumn(name = "job_experience_id")
    private JobExperience jobExperience;

    @ManyToOne()
    @JoinColumn(name = "jobseeker_language_id")
    private JobSeekerLanguage jobSeekerLanguage;

    @ManyToOne()
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @ManyToOne()
    @JoinColumn(name = "programming_language_id")
    private ProgrammingLanguage programmingLanguage;

    @ManyToOne()
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeeker> jobSeekers;

}
