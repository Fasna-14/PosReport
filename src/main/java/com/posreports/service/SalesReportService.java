package com.posreports.service;

import com.posreports.dto.SaleInvoiceAndCancelDto;
import com.posreports.dto.SaleItemsAndCancelDto;
import com.posreports.entity.InvoiceItems;
import com.posreports.entity.RefundItems;
import com.posreports.entity.TblInvoices;
import com.posreports.entity.TblProducts;
import com.posreports.repository.InvoiceItemsRepository;
import com.posreports.repository.RefundItemsRepository;
import com.posreports.repository.TblInvoicesRepository;
import com.posreports.repository.TblProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesReportService {
    @Autowired
    TblInvoicesRepository tblInvoicesRepository;

    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;

    @Autowired
    RefundItemsRepository refundItemsRepository;

    @Autowired
    TblProductsRepository tblProductsRepository;


    public List<SaleInvoiceAndCancelDto> generateInvoices(Date startDate, Date endDate) {
        List<SaleInvoiceAndCancelDto> invoiceDetailsList = new ArrayList<>();

        List<TblInvoices> invoices = tblInvoicesRepository.findByInvoiceDateBetween(startDate, endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (TblInvoices invoice : invoices) {
            if (invoice.getStatus() == 0) {
                // Convert the invoiceDate to formatted date and time strings
                String date = dateFormat.format(invoice.getInvoiceDate());
                String time = timeFormat.format(invoice.getInvoiceDate());

                // Fetch associated invoice items for each invoice
                List<InvoiceItems> invoiceItemsList = invoiceItemsRepository.findByTblInvoicesId(invoice.getId());

                Double netTotalForInvoice = calculateNetTotal(invoiceItemsList);

                // Create DTO and add it to the list
                SaleInvoiceAndCancelDto invoiceDetailsDto = new SaleInvoiceAndCancelDto();
                invoiceDetailsDto.setDate(date);
                invoiceDetailsDto.setTime(time);
                invoiceDetailsDto.setInvoiceNo(invoice.getId());
                invoiceDetailsDto.setNetTotal(netTotalForInvoice);
                invoiceDetailsList.add(invoiceDetailsDto);
            }
        }

        return invoiceDetailsList;
    }

    private Double calculateNetTotal(List<InvoiceItems> invoiceItemsList) {
        Double netTotalForInvoice = 0.0;
        for (InvoiceItems invoiceItem : invoiceItemsList) {
            Double netTotal = invoiceItem.getTotal();
            if (netTotal != null) {
                netTotalForInvoice += netTotal;
            }
        }
        return netTotalForInvoice;
    }

    public List<SaleInvoiceAndCancelDto> generateCanceledInvoices(Date startDate, Date endDate) {
        List<SaleInvoiceAndCancelDto> canceledInvoiceDetailsList = new ArrayList<>();

        List<TblInvoices> canceledInvoices = tblInvoicesRepository.findByInvoiceDateBetween(startDate, endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (TblInvoices invoice : canceledInvoices) {
            if (invoice.getStatus() == 1) {
                // Convert the invoiceDate to formatted date and time strings
                String date = dateFormat.format(invoice.getInvoiceDate());
                String time = timeFormat.format(invoice.getInvoiceDate());

                // Fetch associated invoice items for each invoice
                List<InvoiceItems> invoiceItemsList = invoiceItemsRepository.findByTblInvoicesId(invoice.getId());

                Double netTotalForInvoice = calculateNetTotal(invoiceItemsList);

                // Create DTO and add it to the list
                SaleInvoiceAndCancelDto canceledInvoiceDetailsDto = new SaleInvoiceAndCancelDto();
                canceledInvoiceDetailsDto.setDate(date);
                canceledInvoiceDetailsDto.setTime(time);
                canceledInvoiceDetailsDto.setInvoiceNo(invoice.getId());
                canceledInvoiceDetailsDto.setNetTotal(netTotalForInvoice);
                canceledInvoiceDetailsList.add(canceledInvoiceDetailsDto);
            }
        }
        return canceledInvoiceDetailsList;
    }

    public List<SaleItemsAndCancelDto> generateSaleItems(Date startDate, Date endDate) {
        List<SaleItemsAndCancelDto> salesDetailsList = new ArrayList<>();

        List<TblInvoices> invoices = tblInvoicesRepository.findByInvoiceDateBetween(startDate, endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (TblInvoices invoice : invoices) {
            // Convert the invoiceDate to formatted date and time strings
            String date = dateFormat.format(invoice.getInvoiceDate());
            String time = timeFormat.format(invoice.getInvoiceDate());

            // Fetch associated invoice items for each invoice
            List<InvoiceItems> invoiceItemsList = invoiceItemsRepository.findByTblInvoicesId(invoice.getId());

            for (InvoiceItems invoiceItem : invoiceItemsList) {
                // Fetch the item name from the associated TblProducts
                String itemName = invoiceItem.getTblProducts().getItemName();

                Double netTotalForInvoice = calculateNetTotal(invoiceItemsList);

                // Create DTO and add it to the list
                SaleItemsAndCancelDto invoiceDetailsDto = new SaleItemsAndCancelDto();
                invoiceDetailsDto.setDate(date);
                invoiceDetailsDto.setTime(time);
                invoiceDetailsDto.setItemCode(invoiceItem.getTblProducts().getId());
                invoiceDetailsDto.setItemName(itemName);
                invoiceDetailsDto.setInvoiceNo(invoice.getId());
                invoiceDetailsDto.setQty(invoiceItem.getQty());
                invoiceDetailsDto.setSalePrice(invoiceItem.getSalePrice());
                invoiceDetailsDto.setNetTotal(netTotalForInvoice);
                salesDetailsList.add(invoiceDetailsDto);
            }
        }

        return salesDetailsList;
    }

    public List<SaleItemsAndCancelDto> generateCanceledSaleItems(Date startDate, Date endDate) {
        List<SaleItemsAndCancelDto> CanceledSalesDetailsList = new ArrayList<>();

        List<TblInvoices> invoices = tblInvoicesRepository.findByInvoiceDateBetween(startDate, endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (TblInvoices invoice : invoices) {
            if (invoice.getStatus() == 1) {
                // Convert the invoiceDate to formatted date and time strings
                String date = dateFormat.format(invoice.getInvoiceDate());
                String time = timeFormat.format(invoice.getInvoiceDate());

                // Fetch associated invoice items for each invoice
                List<InvoiceItems> invoiceItemsList = invoiceItemsRepository.findByTblInvoicesId(invoice.getId());

                for (InvoiceItems invoiceItem : invoiceItemsList) {
                    // Fetch the item name from the associated TblProducts
                    String itemName = invoiceItem.getTblProducts().getItemName();

                    Double netTotalForInvoice = calculateNetTotal(invoiceItemsList);

                    // Create DTO and add it to the list
                    SaleItemsAndCancelDto invoiceDetailsDto = new SaleItemsAndCancelDto();
                    invoiceDetailsDto.setDate(date);
                    invoiceDetailsDto.setTime(time);
                    invoiceDetailsDto.setItemCode(invoiceItem.getTblProducts().getId());
                    invoiceDetailsDto.setItemName(itemName);
                    invoiceDetailsDto.setInvoiceNo(invoice.getId());
                    invoiceDetailsDto.setQty(invoiceItem.getQty());
                    invoiceDetailsDto.setSalePrice(invoiceItem.getSalePrice());
                    invoiceDetailsDto.setNetTotal(netTotalForInvoice);
                    CanceledSalesDetailsList.add(invoiceDetailsDto);
                }
            }
        }

        return CanceledSalesDetailsList;
    }



    public List<SaleItemsAndCancelDto> generateRefundItemsByDate(Date startDate, Date endDate) {
        List<SaleItemsAndCancelDto> refundDetailsList = new ArrayList<>();

        List<RefundItems> refundItems = refundItemsRepository.findByAccessDateBetween(startDate,endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (RefundItems refundItem : refundItems) {
            // Convert the accessDate to formatted date and time strings
            String formattedDate = dateFormat.format(refundItem.getAccessDate());
            String formattedTime = timeFormat.format(refundItem.getAccessDate());

            // Fetch associated TblProducts for each refund item
            TblProducts tblProduct = refundItem.getTblProducts();

            if (tblProduct != null) {
                SaleItemsAndCancelDto refundDetailsDto = new SaleItemsAndCancelDto();
                refundDetailsDto.setDate(formattedDate);
                refundDetailsDto.setTime(formattedTime);
                refundDetailsDto.setItemCode(tblProduct.getId());
                refundDetailsDto.setItemName(tblProduct.getItemName());
                refundDetailsDto.setInvoiceNo(refundItem.getId());
                refundDetailsDto.setQty(refundItem.getQty());
                refundDetailsDto.setSalePrice(refundItem.getSalePrice());
                refundDetailsDto.setNetTotal(refundItem.getTotal());
                refundDetailsList.add(refundDetailsDto);
            }
        }

        return refundDetailsList;
    }
}


