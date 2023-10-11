package com.posreports.repository;

import com.posreports.entity.StockOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockOrdersRepository extends JpaRepository<StockOrders,String> {

    List<StockOrders> getStockOrdersByAccessDateBetween(Date startDate, Date endDate);

    List<StockOrders> findByAccessDateBetween(Date startDate, Date endDate);
}
