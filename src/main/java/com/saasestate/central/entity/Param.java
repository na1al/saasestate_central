package com.saasestate.central.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(indexes = {@Index(columnList="estate_id, type")})
public class Param {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)", nullable = false)
    public ParamType type;

    @Basic(optional = false)
    public int value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Estate estate;

    public Param(){
        super();
    }

    public Param(ParamType type, int value){
        super();
        this.type = type;
        this.value = value;
    }


    public  enum ParamType {
        PRICE, AREA_TOTAL, AREA_LIVING, AREA_KITCHEN, FLOOR, FLOORS
    }

}
