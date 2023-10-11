package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "9_tbl_stock_main")
public class TblStockMain {

    @Id
    @Column(name = "BatchNo")
    private String id;

    @ManyToOne
    @JoinColumn(name = "Orderno", referencedColumnName = "Orderno")
    private StockOrders stockOrder;

    @ManyToOne
    @JoinColumn(name = "Product", referencedColumnName = "Itemcode")
    private TblProducts product;

    @Column(name = "Saleprice")
    private Double salePrice;

    @Column(name = "Tradeprice")
    private Double tradePrice;

    @Column(name = "Costprice")
    private Double costPrice;

    @Column(name = "Qty")
    private Double qty;

    @Column(name = "Blocked")
    private Double blocked;

    @Column(name = "Expiredate")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "ProductBatch", length = 100)
    private String productBatch;

}

