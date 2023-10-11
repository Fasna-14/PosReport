package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockSummaryDto {
    private String itemCode;
    private String itemName;
    private Double netQty;
    private Double netValue;

    public StockSummaryDto(String itemCode, String itemName, Double netQty, Double netValue) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.netQty = netQty;
        this.netValue = netValue;
    }
}
