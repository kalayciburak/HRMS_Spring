package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @Column(name = "position_count")
    @NotNull
    private int positionCount;

    @Column(name = "deadline")
    @NotNull
    private LocalDate deadline;

    @Column(name = "airdate")
    @JsonIgnore
    private LocalDateTime airdate = LocalDateTime.now();

    @Column(name = "is_active")
    @NotNull
    private boolean isActive = true;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;
}