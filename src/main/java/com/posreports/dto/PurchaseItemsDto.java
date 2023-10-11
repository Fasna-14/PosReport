package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemsDto {
    private String itemCode;
    private String itemName;
    private Double qty;
    private Double netTotal;
}
