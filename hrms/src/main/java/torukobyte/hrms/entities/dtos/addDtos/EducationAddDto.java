package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationAddDto {
    private int id;
    private int curriculaVitaeId;
    private int schoolId;
    private int departmentId;
    private LocalDate startDate;
    private LocalDate endDate;
}
