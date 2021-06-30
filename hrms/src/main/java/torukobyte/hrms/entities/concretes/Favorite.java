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
@Table(name = "favorites")
public class Favorite {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "job_advert_id")
    private JobAdvert jobAdvert;
}
