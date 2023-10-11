package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "invoice_items")
public class InvoiceItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Invoiceno", referencedColumnName = "Invoiceno")
    private TblInvoices tblInvoices;

    @ManyToOne
    @JoinColumn(name = "Itemcode", referencedColumnName = "Itemcode")
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    @Column(name = "Saving")
    private Double saving;

    @Column(name = "Totaldiscount")
    private Double totalDiscount;

    @Column(name = "NetTotal")
    private Double netTotal;

    @Column(name = "Imeino")
    private String imeiNo;
}
