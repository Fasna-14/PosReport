package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "stock_transection")
public class StockTransection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "Product", referencedColumnName = "Itemcode")
    private TblProducts product;

    @Column(name = "Batchno")
    private String batchNo;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "TransectionID", referencedColumnName = "Id")
    private TblTransection transection;

    @Column(name = "Description")
    private String description;

    @Column(name = "CurrentStock",nullable = false)
    private Double currentStock;

    @Column(name = "AdjustStock",nullable = false)
    private Double adjustStock;

    @Column(name = "AvailableStock",nullable = false)
    private Double availableStock;

    @Column(name = "Accessdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessDate;

    @ManyToOne
    @JoinColumn(name = "Accessuser", referencedColumnName = "Id")
    private TblUsers accessUser;
}
