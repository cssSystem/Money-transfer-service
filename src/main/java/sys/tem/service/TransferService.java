package sys.tem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import sys.tem.exception.ErrorTransferConfirmException;
import sys.tem.model.ConfirmOperation;
import sys.tem.model.RequestResponse;
import sys.tem.model.Transfer;
import sys.tem.model.TransferData;
import sys.tem.repository.TransferRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static sys.tem.MoneyTransferServiceApplication.MI;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;

    public RequestResponse transfer(Transfer transfer) {
        String id = transferRepository.addTransfer(TransferData.builder()
                .transfer(transfer)
                .date(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)))
                .time(LocalTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss.nnn")))
                .build());
        return new RequestResponse(id);
    }


    public RequestResponse confirmOperation(ConfirmOperation confirmOperation) {
        if (confirmOperation.getCode().equals("0000")) {
            if (transferRepository.confirmOperation(confirmOperation.getOperationId())) {
                return new RequestResponse(confirmOperation.getOperationId());
            }
        }
        String msg = "Error Confirm Operation: " + confirmOperation;
        log.info(MI, msg);
        throw new ErrorTransferConfirmException("Error Confirm Operation: " + confirmOperation);
    }
}
