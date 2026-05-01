package com.miniPayMent.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wallet")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "wallet_id")
    private int walletId;
    private String type;
    private BigDecimal amount;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "create_at")
    private Date createAt;
}
