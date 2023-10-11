package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PurchaseInvoicesDto {
    private String invoiceNo;
    private String orderNo;
    private Integer items;
    private String accessDate;
    private Double netTotal;
}
