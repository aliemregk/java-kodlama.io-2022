package Kodlama.io.Devs.business.requests.technologyRequests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
    @NotNull
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    private int languageId;
}
