package com.miniPayMent.repository;

import com.miniPayMent.repository.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByuserId(Integer userId);
    WalletEntity findById(Integer id);
    WalletEntity findByWalletId(String walletId);
}
