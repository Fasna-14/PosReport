package com.posreports.service;

import com.posreports.dto.PurchaseInvoicesDto;
import com.posreports.dto.PurchaseItemsDto;
import com.posreports.entity.StockOrderItems;
import com.posreports.entity.StockOrders;
import com.posreports.entity.TblProducts;
import com.posreports.repository.StockOrderItemsRepository;
import com.posreports.repository.StockOrdersRepository;
import com.posreports.repository.TblProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PurchaseReportService {

    @Autowired
    StockOrderItemsRepository stockOrderItemsRepository;

    @Autowired
    StockOrdersRepository stockOrdersRepository;

    @Autowired
    TblProductsRepository tblProductsRepository;
    public List<PurchaseItemsDto> getPurchaseItemsDataByDateRange(Date startDate, Date endDate) {
        List<PurchaseItemsDto> purchaseItemsDtoList = new ArrayList<>();

        // Fetch StockOrderItems within the date range
        List<StockOrderItems> stockOrderItemsList = stockOrderItemsRepository.getStockOrderItemsByAccessDateRange(startDate, endDate);

        // Create a map to aggregate values for each unique itemCode
        Map<String, PurchaseItemsDto> itemCodeToDtoMap = new HashMap<>();

        for (StockOrderItems stockOrderItem : stockOrderItemsList) {
            String itemCode = stockOrderItem.getProduct().getId();
            double qty = stockOrderItem.getQty();
            double price = stockOrderItem.getPrice();
            double netTotal = qty * price;

            // Check if the itemCode is already in the map
            if (itemCodeToDtoMap.containsKey(itemCode)) {
                // If yes, update the aggregated values
                PurchaseItemsDto existingDto = itemCodeToDtoMap.get(itemCode);
                existingDto.setQty(existingDto.getQty() + qty);
                existingDto.setNetTotal(existingDto.getNetTotal() + netTotal);
            } else {
                // If no, create a new PurchaseItemsDto and add it to the map
                PurchaseItemsDto purchaseItemDto = new PurchaseItemsDto();
                purchaseItemDto.setItemCode(itemCode);
                purchaseItemDto.setItemName(stockOrderItem.getProduct().getItemName());
                purchaseItemDto.setQty(qty);
                purchaseItemDto.setNetTotal(netTotal);
                itemCodeToDtoMap.put(itemCode, purchaseItemDto);
            }
        }

        // Add the aggregated PurchaseItemsDto objects to the result list
        purchaseItemsDtoList.addAll(itemCodeToDtoMap.values());

        return purchaseItemsDtoList;
    }

    public List<PurchaseInvoicesDto> getPurchaseInvoicesData(Date startDate, Date endDate) {
        List<PurchaseInvoicesDto> purchaseInvoicesDtoList = new ArrayList<>();

        // Fetch StockOrders from the repository
        List<StockOrders> stockOrdersList = stockOrdersRepository.getStockOrdersByAccessDateBetween(startDate,endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Map StockOrders entities to PurchaseInvoicesDto
        for (StockOrders stockOrder : stockOrdersList) {
            String formattedDate = dateFormat.format(stockOrder.getAccessDate());

            PurchaseInvoicesDto purchaseInvoicesDto = new PurchaseInvoicesDto();
            purchaseInvoicesDto.setInvoiceNo(stockOrder.getInvoiceNo());
            purchaseInvoicesDto.setOrderNo(stockOrder.getOrderNo());
            purchaseInvoicesDto.setItems(stockOrder.getItems());
            purchaseInvoicesDto.setAccessDate(formattedDate);
            purchaseInvoicesDto.setNetTotal(stockOrder.getNetTotal());

            // Add the mapped DTO to the result list
            purchaseInvoicesDtoList.add(purchaseInvoicesDto);
        }

        return purchaseInvoicesDtoList;
    }
}
