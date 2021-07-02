package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeAddDto {
    private int id;
    private int jobSeekerId;
    private String coverLetter = "";
}
