package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites"})

public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "description")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //düzenlenebilir gibi görünsede auto değer atıyor.
    private LocalDateTime airdate = LocalDateTime.now();

    @Column(name = "uptime")
    @NotNull
    private String upTime;

    @Column(name = "type_of_employment")
    @NotNull
    private String typeOfEmployment;

    @Column(name = "is_active")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isActive = true;

    @Column(name = "is_confirmed")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isConfirmed = false;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "jobAdvert", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;
}