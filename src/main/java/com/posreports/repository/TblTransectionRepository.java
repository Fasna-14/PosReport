package com.posreports.repository;

import com.posreports.dto.TransectionReportDto;
import com.posreports.entity.TblTransection;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TblTransectionRepository extends JpaRepository<TblTransection,String > {
    @Query("SELECT new com.posreports.dto.TransectionReportDto(" +
            "DATE(st.accessDate), " +
            "TIME(st.accessDate), " +
            "st.product.id, " +
            "st.product.itemName, " +
            "st.transection.description, " +
            "st.description, " +
            "st.currentStock, " +
            "st.adjustStock, " +
            "(st.currentStock + st.adjustStock)) " +
            "FROM StockTransection st " +
            "JOIN st.product p " +
            "JOIN st.transection t " +
            "WHERE st.accessDate BETWEEN :startDate AND :endDate")
    List<TransectionReportDto> getTransectionReportData(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);



}
