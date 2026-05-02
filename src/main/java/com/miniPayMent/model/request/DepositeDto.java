package com.miniPayMent.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositeDto {
    private String walletId;
    private BigDecimal amount;
}
