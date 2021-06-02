package torukobyte.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pictures")
public class Picture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne()
    @JoinColumn(name = "curricula_vitae_id")
    private CurriculaVitae curriculaVitae;
}
