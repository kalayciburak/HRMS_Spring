package torukobyte.hrms.entities.concretes;

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

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<SocialMedia> socialMedias;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Technology> technologies;
}
