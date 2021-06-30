package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {
    private int id;
    private int curriculaVitaeId;
    private String companyName;
    private String positionName;
    private LocalDate startDate;
    private LocalDate endDate;
}
