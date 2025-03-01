package sys.tem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ConfirmOperation {
    @NotBlank
    private String code;
    private String operationId;
}
