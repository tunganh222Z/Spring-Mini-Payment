package com.miniPayMent.service.impl;

import com.miniPayMent.model.CreateWalletDto;
import com.miniPayMent.model.UserDto;
import com.miniPayMent.repository.WalletRepository;
import com.miniPayMent.repository.entity.WalletEntity;
import com.miniPayMent.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletEntity createWallet(CreateWalletDto request) {
        UserDto userDto = userService.getUser(request.getUserName(),request.getPersonalId());
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUserId(userDto.getId());
        walletEntity.setCreateAt(new Date());
        walletEntity.setStatus("ACTIVE");
        walletEntity.setBalance(BigDecimal.ZERO);
        walletEntity.setWalletId(UUID.randomUUID().toString());
        walletRepository.save(walletEntity);
        return walletEntity;
    }
}
