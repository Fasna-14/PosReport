package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "5_tbl_products")
public class TblProducts {
    @Id
    @Column(name = "Itemcode")
    private String id;

    @Column(name = "Supplier")
    private String supplier;

//    @JoinColumn(name = "Id")
//    private Department department;

    //    @JoinColumn(name = "Id")
//    private Brand brand;

    //    @JoinColumn(name = "Id")
//    private Category category;

    @Column(name = "Itemname")
    private String itemName;

    @Column(name = "Shortname")
    private String shortName;

    @Column(name = "Is_Warrenty")
    private int isWarrenty;

    @Column(name = "Is_Stock")
    private int isStock;

    @Column(name = "Is_Expire")
    private int isExpire;

    @Column(name = "Boxsize")
    private int boxSize;

    @Column(name = "Max_Limit")
    private Double maxLimit;

    @Column(name = "Min_Limit")
    private Double minLimit;

    @Column(name = "Saleprice")
    private Double salePrice;

    @Column(name = "Tradeprice")
    private Double tradePrice;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Createdate")
    private Timestamp createDate;

    @Column(name = "Createuser")
    private String createUser;

    @Column(name = "Accessdate")
    private Timestamp accessDate;

    @Column(name = "Accessuser")
    private String accessUser;
}
