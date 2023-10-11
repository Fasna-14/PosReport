package com.posreports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "10_tbl_transections")
public class TblTransection {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Description")
    private String description;
}
