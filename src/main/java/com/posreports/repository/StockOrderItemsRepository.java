package com.posreports.repository;

import com.posreports.entity.StockOrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StockOrderItemsRepository extends JpaRepository<StockOrderItems,Long> {
    @Query("SELECT soi FROM StockOrderItems soi " +
            "INNER JOIN soi.product p " +
            "WHERE p.accessDate BETWEEN :startDate AND :endDate")
    List<StockOrderItems> getStockOrderItemsByAccessDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}


