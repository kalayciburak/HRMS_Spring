package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @Column(name = "position_count")
    @NotNull
    private int positionCount;

    @Column(name = "deadline")
    @NotNull
    private LocalDate deadline;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}