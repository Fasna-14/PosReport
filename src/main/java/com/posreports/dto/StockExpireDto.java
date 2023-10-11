package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockExpireDto {
    private String itemCode;
    private String itemName;
    private Double salePrice;
    private Double tradePrice;
    private Double costPrice;
    private Double netQty;
    private Double netValue;

    public StockExpireDto(String itemCode, String itemName,Double salePrice,Double tradePrice,Double costPrice,Double netQty, Double netValue) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.costPrice = costPrice;
        this.tradePrice = tradePrice;
        this.salePrice = salePrice;
        this.netQty = netQty;
        this.netValue = netValue;
    }
}
