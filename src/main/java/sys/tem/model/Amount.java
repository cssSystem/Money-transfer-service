package sys.tem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Amount {
    private int value;
    @NotBlank
    private String currency;
}
