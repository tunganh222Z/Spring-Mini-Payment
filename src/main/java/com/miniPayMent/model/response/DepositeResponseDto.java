package com.miniPayMent.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositeResponseDto {
    private boolean success;
    private BigDecimal amount;
    private String message;
    private String walletId;

    public DepositeResponseDto(boolean success, BigDecimal amount, String message, String walletId) {
        this.success = success;
        this.amount = amount;
        this.message = message;
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return String.format("Nạp tiền %s vào ví %s với số tiền %s",
                this.success ? "thành công" : "thất bại",
                this.walletId,
                this.amount.toString()
                );
    }
}
