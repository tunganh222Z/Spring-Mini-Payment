package com.miniPayMent.service;

import com.miniPayMent.model.CreateWalletDto;
import com.miniPayMent.repository.entity.WalletEntity;

public interface WalletService {
    WalletEntity createWallet(CreateWalletDto request);
}
