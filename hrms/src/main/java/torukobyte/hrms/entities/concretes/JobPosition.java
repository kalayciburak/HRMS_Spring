package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_title"})})
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "job_title")
    @NotNull
    private String jobTitle;

    @OneToOne(mappedBy = "jobPosition")
    private JobAdvert jobAdvert;
}
