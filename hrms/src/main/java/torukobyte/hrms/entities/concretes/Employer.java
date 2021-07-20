package torukobyte.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String website;

    @Column(name = "phone_number")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String phoneNumber;

    @Column(name = "picture_url")
    private String pictureUrl = "https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png";

    @Column(name = "is_updated")
    private boolean isUpdated = false;

    /*@NotNull
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;*/

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> adverts;
}