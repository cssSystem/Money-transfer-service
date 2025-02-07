package sys.tem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Transfer {
    @NotBlank
    @Size(min = 16, max = 16)
    private String cardFromNumber;
    @NotBlank
    @Size(min = 5, max = 5)
    private String cardFromValidTill;
    @NotBlank
    @Size(min = 3, max = 3)
    private String cardFromCVV;
    @NotBlank
    @Size(min = 16, max = 16)
    private String cardToNumber;
    private Amount amount;
}
