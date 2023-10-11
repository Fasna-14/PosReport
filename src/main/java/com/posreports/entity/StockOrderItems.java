package com.posreports.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "stock_order_items")
public class StockOrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Orderno", referencedColumnName = "Orderno")
    private StockOrders stockOrder;

    @ManyToOne
    @JoinColumn(name = "Product", referencedColumnName = "Itemcode")
    private TblProducts product;

    @Column(name = "Qty")
    private Double qty;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Expense")
    private Double expense;

    @Column(name = "Costprice")
    private Double costPrice;

    @Column(name = "Salepercentage")
    private Double salePercentage;

    @Column(name = "Saleprice")
    private Double salePrice;

    @Column(name = "Tradeprice")
    private Double tradePrice;

    @Column(name = "NetTotal")
    private Double netTotal;

    @Column(name = "Expiredate")
    private Date expireDate;

    @Column(name = "BatchNo")
    private String batchNo;

    @Column(name = "ReturnQty")
    private Double returnQty;

    @Column(name = "ReturnAmount")
    private Double returnAmount;

}

