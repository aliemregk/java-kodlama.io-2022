package kodlama.io.rentACar.business.requests.brand;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    @NotNull
    @NotBlank
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
}
