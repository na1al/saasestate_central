package com.saasestate.central.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column( columnDefinition = "varchar(100)")
    private String placeId;

    @Basic
    private String name;

    private double lat;

    private double lng;

}
