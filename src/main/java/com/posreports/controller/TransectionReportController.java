package com.posreports.controller;

import com.posreports.dto.SaleInvoiceAndCancelDto;
import com.posreports.dto.TransectionReportDto;
import com.posreports.entity.StockTransection;
import com.posreports.service.TransectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TransectionReportController {

    @Autowired
    TransectionReportService transectionReportService;

    @GetMapping("/transections")
    public ResponseEntity<List<TransectionReportDto>> generateInvoicesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<TransectionReportDto> report = transectionReportService.getTransectionReportData(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}
