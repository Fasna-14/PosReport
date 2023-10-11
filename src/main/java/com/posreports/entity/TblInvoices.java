package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "12_tbl_invoices")
public class TblInvoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Invoiceno")
    private Long id;

    @Column(name = "Invoicedate")
    private Timestamp invoiceDate;
//    @ManyToOne
//    @JoinColumn(name = "Id")
//    private Customer customer;

    @Column(name = "Status")
    private int status;

//    @ManyToOne
//    @JoinColumn(name = "shiftNo")
//    private TblShift shift;

//    @ManyToOne
//    @JoinColumn(name = "Accessuser")
//    private Accessuser accessUser;

    @Column(name = "Accessdate")
    private Timestamp accessDate;
}
