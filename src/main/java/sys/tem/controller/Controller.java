package sys.tem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sys.tem.model.ConfirmOperation;
import sys.tem.model.RequestResponse;
import sys.tem.model.Transfer;
import sys.tem.service.TransferService;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final TransferService transferService;

    @PostMapping("/transfer")
    public RequestResponse transfer(@Valid @RequestBody Transfer transfer) {
        return transferService.transfer(transfer);
    }

    @PostMapping("/confirmOperation")
    public RequestResponse confirmOperation(@Valid @RequestBody ConfirmOperation confirmOperation) {
        return transferService.confirmOperation(confirmOperation);
    }
}
