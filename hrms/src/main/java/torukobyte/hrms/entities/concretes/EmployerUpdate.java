package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers_update", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

    @Column(name = "id")
    @Id
    @NotNull
    private int id;

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

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "picture_url")
    private String pictureUrl = "https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png";

}