package com.miniPayMent.api;


import com.miniPayMent.model.request.CreateWalletDto;
import com.miniPayMent.model.response.ErrorResponse;
import com.miniPayMent.repository.entity.WalletEntity;
import com.miniPayMent.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WalletApi {
    @Autowired
    private WalletServiceImpl walletService;

    @PostMapping(value = "/wallets")
    public ErrorResponse createWallet(@RequestBody CreateWalletDto request) {
        WalletEntity entity = walletService.createWallet(request);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setSuccess(true);
        errorResponse.getDetails().add(entity.getWalletId() + " " + entity.getStatus());
        errorResponse.setMessage("Đã tạo wallet cho user " + request.getUserName() + " với personalId " + request.getPersonalId());

        return errorResponse;
    }
}
