package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteAddDto {
    private int id;
    private int jobSeekerId;
    private int jobAdvertId;
}
