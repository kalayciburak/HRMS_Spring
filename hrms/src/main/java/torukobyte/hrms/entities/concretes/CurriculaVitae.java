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
    private String pictureUrl = "https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.ALL)
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.ALL)
    private List<Technologie> technologies;
}
