package sys.tem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Amount {
    private int value;
    @NotBlank
    private String currency;
}
