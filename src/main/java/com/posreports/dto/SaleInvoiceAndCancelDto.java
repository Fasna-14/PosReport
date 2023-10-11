package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class SaleInvoiceAndCancelDto {
    private String date;
    private String time;
    private Long invoiceNo;
    private Double netTotal;
}
