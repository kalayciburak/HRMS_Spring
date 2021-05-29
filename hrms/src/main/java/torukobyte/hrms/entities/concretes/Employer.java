package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "website")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String website;

    @Column(name = "phone_number")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String phoneNumber;

    @NotNull
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> adverts;
}