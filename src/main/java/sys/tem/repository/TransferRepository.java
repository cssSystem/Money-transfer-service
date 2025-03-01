package sys.tem.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import sys.tem.exception.ErrorTransferConfirmException;
import sys.tem.model.ConfirmOperation;
import sys.tem.model.TransferData;
import sys.tem.model.TransferStatus;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static sys.tem.MoneyTransferServiceApplication.MI;

@Log4j2
@Repository
public class TransferRepository {

    private ConcurrentHashMap<String, TransferData> transferMap = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();

    public String addTransfer(TransferData transfer) {
        String id = String.valueOf(this.id.incrementAndGet());
        transfer.setTransferStatus(TransferStatus.load);
        transferMap.put(id, transfer);

        log.info(MI, "SET TRANSFER : id " + id + " : " + transfer);

        return id;
    }

    public boolean confirmOperation(String operationId) {
        if (transferMap.containsKey(operationId)) {
            TransferData transferData = transferMap.get(operationId);
            if (transferData.getTransferStatus() != TransferStatus.load) {
                String msg = "Error Confirm Operation: " + new ConfirmOperation("0000", operationId);
                log.info(MI, msg);
                throw new ErrorTransferConfirmException(msg);
            }
            transferData.setTransferStatus(TransferStatus.ok);

            log.info(MI, "UPD TRANSFER : id " + operationId + " : " + transferMap.get(operationId));

            return true;
        }
        log.info(MI, "NO TRANSFER NUMBER : id " + operationId);
        return false;
    }
}
