package com.miniPayMent.service.impl;

import com.miniPayMent.custom_exception.WalletException;
import com.miniPayMent.model.request.DepositeDto;
import com.miniPayMent.model.response.DepositeResponseDto;
import com.miniPayMent.repository.TransactionRepository;
import com.miniPayMent.repository.WalletRepository;
import com.miniPayMent.repository.entity.TransactionEntity;
import com.miniPayMent.repository.entity.WalletEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TransactionServiceImpl {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DepositeResponseDto depositeToWalletId(DepositeDto request) {
        if (!(request.getAmount().compareTo(BigDecimal.ZERO) > 0)) {
            throw new WalletException(
                    "Amount deposite phải lớn hơn 0",
                    HttpStatus.BAD_GATEWAY,
                    502
            );
        }
        WalletEntity walletEntity = walletRepository.findByWalletId(request.getWalletId());
        checkValidateWallet(walletEntity.getStatus());
        TransactionEntity transactionEntity = modelMapper.map(walletEntity, TransactionEntity.class);
        transactionEntity.setAmount(request.getAmount());
        transactionEntity.setCreateAt(new Date());

        transactionRepository.save(transactionEntity);
        boolean res = true;
        if (res) {
            walletRepository.save(updateWalletAfterTransaction(walletEntity, request.getAmount()));
        }
        return new DepositeResponseDto(true, request.getAmount(), "Nạp tiền thành công", walletEntity.getWalletId());
    }

    private WalletEntity updateWalletAfterTransaction(WalletEntity walletEntity, BigDecimal amount) {
        amount = walletEntity.getBalance().add(amount);
        walletEntity.setBalance(amount);
        return walletEntity;
    }

    private void checkValidateWallet(String status) {
        if (!status.equalsIgnoreCase("ACTIVE")) {
            throw new WalletException(
                    "Wallet không hoạt động",
                    HttpStatus.BAD_GATEWAY,
                    502
            );
        }
    }
}
