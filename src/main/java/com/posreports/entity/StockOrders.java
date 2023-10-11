package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "8_tbl_stock_orders")
public class StockOrders {

    @Id
    @Column(name = "Orderno")
    private String orderNo;

    @Column(name = "Orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "Receivedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDate;

    @Column(name = "Invoiceno")
    private String invoiceNo;

    @ManyToOne
    @JoinColumn(name = "Supplier", referencedColumnName = "Id")
    private Supplier supplier;

    @Column(name = "Items")
    private Integer items;

    @Column(name = "Qty")
    private Double qty;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Expense")
    private Double expense;

    @Column(name = "Nettotal")
    private Double netTotal;

    @Column(name = "ReturnAmount")
    private Double returnAmount;

    @Column(name = "GrandTotal")
    private Double grandTotal;

    @Column(name = "Status")
    private String status;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "Createuser")
    private String createUser;

    @Column(name = "Accessdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessDate;

    @Column(name = "Accessuser")
    private String accessUser;

    @Column(name = "is_old")
    private Integer isOld;
}
