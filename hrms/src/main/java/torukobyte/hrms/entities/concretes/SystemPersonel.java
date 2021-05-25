package torukobyte.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "system_personels", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonel extends User {

    @Column(name = "personel_id")
    @NotNull
    private int id;

    @Column(name = "username")
    @NotNull
    private String username;
}
