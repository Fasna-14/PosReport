package com.posreports.service;

import com.posreports.dto.StockExpireDto;
import com.posreports.dto.StockSummaryDto;
import com.posreports.entity.StockOrders;
import com.posreports.entity.TblProducts;
import com.posreports.entity.TblStockMain;
import com.posreports.repository.StockOrdersRepository;
import com.posreports.repository.TblProductsRepository;
import com.posreports.repository.TblStockMainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockReportService {
    @Autowired
    private StockOrdersRepository stockOrdersRepository;

    @Autowired
    private TblStockMainRepository tblStockMainRepository;

    @Autowired
    private TblProductsRepository tblProductsRepository;

    public List<StockSummaryDto> getStockSummaryData() {
        return tblStockMainRepository.getStockSummaryData();
    }

    public List<StockExpireDto> getStockBatchData(Date startDate, Date endDate) {
        return tblStockMainRepository.getStockBatchData(startDate, endDate);
    }


}
