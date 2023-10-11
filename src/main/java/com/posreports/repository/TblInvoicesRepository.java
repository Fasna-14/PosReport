package com.posreports.repository;

import com.posreports.entity.TblInvoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface TblInvoicesRepository extends JpaRepository<TblInvoices,Long> {
    //@Query("SELECT i FROM TblInvoices i WHERE i.invoiceDate BETWEEN :startDate AND :endDate")
    List<TblInvoices> findByInvoiceDateBetween(Date startDate, Date endDate);
}
