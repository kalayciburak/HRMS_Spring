package torukobyte.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "job_title")
    private String jobTitle;

    public JobPosition() {
    }

    public JobPosition(int id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }
}
