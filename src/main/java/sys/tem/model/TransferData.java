package sys.tem.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
public class TransferData {
    private Transfer transfer;
    private TransferStatus transferStatus;
    private String date;
    private String time;
}
