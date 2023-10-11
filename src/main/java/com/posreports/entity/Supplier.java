package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "7_tbl_suppliers")
public class Supplier {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Note")
    private String note;

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
}
