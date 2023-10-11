package com.posreports.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class TransectionReportDto {
    private Date date;
    private Time time;
    private String itemCode;
    private String itemName;
    private String transection;
    private String reMarks;
    private Double currentStock;
    private Double adjustStock;
    private Double availableStock;

    public TransectionReportDto(Date date, Time time, String itemCode, String itemName, String transection, String reMarks, Double actualQty, Double adjustQty, Double balanceQty) {
        this.date = date;
        this.time = time;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.transection = transection;
        this.reMarks = reMarks;
        this.currentStock = actualQty;
        this.adjustStock = adjustQty;
        this.availableStock = balanceQty;
    }

}
