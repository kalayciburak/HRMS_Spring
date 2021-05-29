package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "identity_number")
    @NotNull
    private String identityNumber;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

}

