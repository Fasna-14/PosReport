package com.posreports.controller;

import com.posreports.dto.SaleInvoiceAndCancelDto;
import com.posreports.dto.SaleItemsAndCancelDto;
import com.posreports.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@RestController
public class SaleReportController {
    @Autowired
    SalesReportService salesReportService;

    @GetMapping("/invoices")
    public ResponseEntity<List<SaleInvoiceAndCancelDto>> generateInvoicesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<SaleInvoiceAndCancelDto> report = salesReportService.generateInvoices(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/invoices-cancel")
    public ResponseEntity<List<SaleInvoiceAndCancelDto>> generateCanceledInvoicesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<SaleInvoiceAndCancelDto> report = salesReportService.generateCanceledInvoices(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/sales-items")
    public ResponseEntity<List<SaleItemsAndCancelDto>> generateSalesItemsReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<SaleItemsAndCancelDto> report = salesReportService.generateSaleItems(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/sales-cancel")
    public ResponseEntity<List<SaleItemsAndCancelDto>> generateCanceledSalesItemsReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<SaleItemsAndCancelDto> report = salesReportService.generateCanceledSaleItems(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/sales-refund")
    public ResponseEntity<List<SaleItemsAndCancelDto>> generateRefundItemsDate(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        List<SaleItemsAndCancelDto> report = salesReportService.generateRefundItemsByDate(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}
