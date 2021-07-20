package torukobyte.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyUpdateDto {
    private int id;
    private int curriculaVitaeId;
    private String plName;
}
