package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItemsAndCancelDto {
    private String date;
    private String time;
    private String itemCode;
    private String itemName;
    private Long invoiceNo;
    private Double qty;
    private Double salePrice;
    private Double netTotal;
}
