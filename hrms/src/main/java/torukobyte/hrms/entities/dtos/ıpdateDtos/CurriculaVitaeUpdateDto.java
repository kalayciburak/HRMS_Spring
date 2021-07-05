package torukobyte.hrms.entities.dtos.ıpdateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeUpdateDto {
    private int id;
    private int jobSeekerId;
    private String pictureUrl;
    private String coverLetter = "";
}



