package sys.tem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConfirmOperation {
    @NotBlank
    private String code;
    private String operationId;
}
