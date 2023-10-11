package com.posreports.controller;

import com.posreports.dto.PurchaseInvoicesDto;
import com.posreports.dto.PurchaseItemsDto;
import com.posreports.dto.SaleInvoiceAndCancelDto;
import com.posreports.service.PurchaseReportService;
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
public class PurchaseReportController {

    @Autowired
    PurchaseReportService purchaseReportService;

    @GetMapping("/purchase-items")
    public ResponseEntity<List<PurchaseItemsDto>> generatePurchaseItemsReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<PurchaseItemsDto> report = purchaseReportService.getPurchaseItemsDataByDateRange(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/purchase-invoices")
    public ResponseEntity<List<PurchaseInvoicesDto>> generatePurchaseInvoicesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<PurchaseInvoicesDto> report = purchaseReportService.getPurchaseInvoicesData(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}
