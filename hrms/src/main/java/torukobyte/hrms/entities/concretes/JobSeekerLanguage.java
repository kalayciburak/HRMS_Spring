package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_languages")
public class JobSeekerLanguage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "language_degree")
    @Min(1)
    @Max(5)
    @NotNull
    @NotBlank
    private int languageDegree;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeekerLanguage")
    private List<CurriculaVitae> curriculaVitaes;
}
