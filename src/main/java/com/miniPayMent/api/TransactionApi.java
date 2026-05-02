package com.miniPayMent.api;


import com.miniPayMent.model.request.DepositeDto;
import com.miniPayMent.model.response.DepositeResponseDto;
import com.miniPayMent.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class TransactionApi {
    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping(value = "/deposite")
    public DepositeResponseDto transDeposite(@RequestBody DepositeDto request) {
        DepositeResponseDto response = transactionService.depositeToWalletId(request);
        return response;
    }
}
