package torukobyte.hrms.entities.dtos.ıpdateDtos;

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
