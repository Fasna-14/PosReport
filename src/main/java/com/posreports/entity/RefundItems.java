package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "refund_items")
public class RefundItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Shiftno")
    private String shiftNo;

    @ManyToOne
    @JoinColumn(name = "Itemcode", referencedColumnName = "Itemcode")
    private TblProducts tblProducts;

    @Column(name = "Batchno")
    private String batchNo;

    @Column(name = "Qty")
    private Double qty;

    @Column(name = "Saleprice")
    private Double salePrice;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Totaldiscount")
    private Double totalDiscount;

    @Column(name = "Saving")
    private Double saving;

    @Column(name = "NetTotal")
    private Double netTotal;

    @Column(name = "Imeino")
    private String imeiNo;

    @Column(name = "Accessuser")
    private String accessUser;

    @Column(name = "Accessdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessDate;

}

