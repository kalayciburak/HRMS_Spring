package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employers", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    @NotNull
    private int id;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "webiste")
    @NotNull
    private String website;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @NotNull
    private String confirmPassword;
}