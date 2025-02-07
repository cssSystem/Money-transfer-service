package sys.tem.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TransferData {
    private Transfer transfer;
    private TransferStatus transferStatus;
    private String date;
    private String time;
}
