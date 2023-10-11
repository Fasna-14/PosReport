package com.posreports.repository;

import com.posreports.entity.InvoiceItems;
import com.posreports.entity.TblInvoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems,Long> {
    //@Query("SELECT i FROM InvoiceItems i WHERE i.tblInvoices.id = :invoiceNo")
    List<InvoiceItems> findByTblInvoicesId(Long invoiceId);
}
