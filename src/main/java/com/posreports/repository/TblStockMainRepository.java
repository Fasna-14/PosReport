package com.posreports.repository;

import com.posreports.dto.StockExpireDto;
import com.posreports.dto.StockSummaryDto;
import com.posreports.entity.StockOrders;
import com.posreports.entity.TblStockMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TblStockMainRepository extends JpaRepository<TblStockMain,String> {

    @Query("SELECT new com.posreports.dto.StockSummaryDto(p.id, p.itemName, SUM(sm.qty), SUM(sm.qty * sm.costPrice)) " +
            "FROM TblStockMain sm JOIN sm.product p WHERE sm.qty <> 0 GROUP BY p.id, p.itemName")
    List<StockSummaryDto> getStockSummaryData();

    @Query("SELECT new com.posreports.dto.StockExpireDto(sm.product.id, sm.product.itemName, sm.salePrice, sm.tradePrice, sm.costPrice, SUM(sm.qty), SUM(sm.qty * sm.costPrice)) " +
            "FROM TblStockMain sm " +
            "JOIN sm.product p " +
            "WHERE sm.qty <> 0 " +
            "AND sm.expireDate BETWEEN :startDate AND :endDate " +
            "GROUP BY sm.product.id, sm.product.itemName")
    List<StockExpireDto> getStockBatchData(@Param("startDate") Date startDate, @Param("endDate") Date endDate);



}
