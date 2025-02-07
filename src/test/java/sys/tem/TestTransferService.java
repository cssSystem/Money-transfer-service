package sys.tem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sys.tem.model.ConfirmOperation;
import sys.tem.model.RequestResponse;
import sys.tem.model.Transfer;
import sys.tem.repository.TransferRepository;
import sys.tem.service.TransferService;

class TestTransferService {

    public TransferService transferService;
    public TransferRepository transferRepository;
    public RequestResponse res = new RequestResponse("1");

    @BeforeEach
    public void init() {
        transferRepository = new TransferRepository();
        transferService = new TransferService(transferRepository);
    }

    @Test
    void transferTest() {
        Transfer mockTransfer = Mockito.mock(Transfer.class);
        Assertions.assertEquals(transferService.transfer(mockTransfer), res);
    }

    @Test
    void confirmOperationTest() {
        ConfirmOperation mockConfirm = Mockito.mock(ConfirmOperation.class);
        Mockito.when(mockConfirm.getOperationId()).thenReturn("1");
        Mockito.when(mockConfirm.getCode()).thenReturn("0000");
        Transfer mockTransfer = Mockito.mock(Transfer.class);
        transferService.transfer(mockTransfer);
        Assertions.assertEquals(transferService.confirmOperation(mockConfirm), res);
    }

}
