package com.posreports.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "1_tbl_users")
public class TblUsers {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Sale_Access")
    private Integer saleAccess;

    @Column(name = "Control_Access")
    private Integer controlAccess;

    @Column(name = "User_Access")
    private Integer userAccess;

    @Column(name = "SaleR_Access")
    private Integer saleRAccess;

    @Column(name = "Purchase_Access")
    private Integer purchaseAccess;

    @Column(name = "Stock_Access")
    private Integer stockAccess;

    @Column(name = "Transection_Access")
    private Integer transectionAccess;

    @Column(name = "Payment_Access")
    private Integer paymentAccess;

    @Column(name = "Customer_Credit_Access")
    private Integer customerCreditAccess;

    @Column(name = "Supplier_Credit_Access")
    private Integer supplierCreditAccess;

    @Column(name = "Profit_Access")
    private Integer profitAccess;

    @Column(name = "Shift_Access")
    private Integer shiftAccess;
}
