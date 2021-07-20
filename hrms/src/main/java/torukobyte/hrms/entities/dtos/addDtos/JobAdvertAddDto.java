package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {
    private int id;
    private int employerId;
    private int cityId;
    private int jobPositionId;
    private String description;
    private LocalDate deadline;
    private String uptime;
    private String typeOfEmployement;
    private int positionCount;
    private int salary;


}
