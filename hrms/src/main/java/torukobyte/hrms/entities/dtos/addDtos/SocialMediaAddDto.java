package torukobyte.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaAddDto {
    private int id;
    private int curriculaVitaeId;
    private String githubUsername;
    private String linkedinUsername;
}
