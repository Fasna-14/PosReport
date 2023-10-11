package com.posreports.service;

import com.posreports.dto.TransectionReportDto;
import com.posreports.entity.StockTransection;
import com.posreports.entity.TblProducts;
import com.posreports.entity.TblTransection;
import com.posreports.repository.StockOrdersRepository;
import com.posreports.repository.StockTransectionRepository;
import com.posreports.repository.TblProductsRepository;
import com.posreports.repository.TblTransectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransectionReportService {
    @Autowired
    TblTransectionRepository tblTransectionRepository;

    @Autowired
    StockTransectionRepository stockTransectionRepository;

    @Autowired
    TblProductsRepository tblProductsRepository;

        public List<TransectionReportDto> getTransectionReportData(Date startDate, Date endDate) {
        return tblTransectionRepository.getTransectionReportData(startDate,endDate);
  }
//    public List<TransectionReportDto> generateTransectionReport(Date startDate, Date endDate) {
//        List<TransectionReportDto> reportData = new ArrayList<>();
//
//        // Retrieve stock transactions between startDate and endDate
//        List<StockTransection> transactions = stockTransectionRepository.getAllWhichHaveAccessDateBetween(startDate, endDate);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//
//        for (StockTransection transaction : transactions) {
//            String date = dateFormat.format(transaction.getAccessDate());
//            String time = timeFormat.format(transaction.getAccessDate());
//
//            // Fetch additional information from related tables
//            TblProducts product = transaction.getProduct();
//            TblTransection tblTransection = transaction.getTransection();
//
//
//            // Create and populate a TransectionReportDto object
//            TransectionReportDto dto = new TransectionReportDto();
//            dto.setDate(date);
//            dto.setTime(time);
//            dto.setItemCode(product.getId());
//            dto.setItemName(product.getItemName());
//            dto.setTransection(tblTransection.getDescription());
//            dto.setReMarks(transaction.getDescription());
//            dto.setCurrentStock(transaction.getCurrentStock());
//            dto.setAdjustStock(transaction.getAdjustStock());
//            dto.setAvailableStock(transaction.getAvailableStock());
//
//            reportData.add(dto);
//        }
//        return reportData;
//
//    }
}
