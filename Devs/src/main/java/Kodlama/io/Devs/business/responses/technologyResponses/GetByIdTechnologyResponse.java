package Kodlama.io.Devs.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
    private String name;
    private String languageName;
}
