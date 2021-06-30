package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculaVitae"})

public class Technology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "technologies")
    private String plName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;
}
