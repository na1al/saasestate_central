package com.saasestate.central.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(EstateAddressNearest.EstateNearestId.class)
public class EstateAddressNearest implements Serializable {

    @Setter
    @Id
    @ManyToOne
    @JoinColumn(name = "estate_id", referencedColumnName = "id")
    private Estate estate;

    @Getter
    @Setter
    @Id
    @ManyToOne
    @JoinColumn(name = "nearest_id", referencedColumnName = "id")
    private AddressNearest nearest;

    @Getter
    @Setter
    @Basic
    private double value;

    public static class EstateNearestId implements Serializable {
        private Integer estate;
        private Integer nearest;
    }

}
