package torukobyte.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaUpdateDto {
    private int id;
    private int curriculaVitaeId;
    private String githubUsername;
    private String linkedinUsername;
}
