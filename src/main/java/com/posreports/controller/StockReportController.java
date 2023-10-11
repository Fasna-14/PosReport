package com.posreports.controller;

import com.posreports.dto.SaleInvoiceAndCancelDto;
import com.posreports.dto.StockExpireDto;
import com.posreports.dto.StockSummaryDto;
import com.posreports.service.StockReportService;
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
public class StockReportController {

    @Autowired
    StockReportService stockReportService;
    @GetMapping("/stock-summary")
    public ResponseEntity<List<StockSummaryDto>> generateStockSummaryReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<StockSummaryDto> report = stockReportService.getStockSummaryData();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/stock-expire")
    public ResponseEntity<List<StockExpireDto>> generateStockBatchesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<StockExpireDto> report = stockReportService.getStockBatchData(startDate,endDate);
        return ResponseEntity.ok(report);
    }
}
