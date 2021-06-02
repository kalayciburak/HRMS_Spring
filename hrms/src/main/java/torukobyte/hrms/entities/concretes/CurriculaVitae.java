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
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeeker> jobSeekers;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobExperience> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<Picture> pictures;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<ProgrammingLanguage> programmingLanguages;
}
