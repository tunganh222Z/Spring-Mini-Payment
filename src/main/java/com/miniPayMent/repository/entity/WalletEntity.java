package com.miniPayMent.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wallets")
@Getter
@Setter
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;
    private BigDecimal balance;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "wallet_id")
    private String walletId;

    @Column(name = "create_at")
    private Date createAt;
}
