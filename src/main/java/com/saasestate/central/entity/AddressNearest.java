package com.saasestate.central.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AddressNearest extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Setter
    @Basic
    public String name;

    @Setter
    @Basic
    public String description;

    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public FileEntity ico;

    @Setter
    @Getter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    public Address address;

    @OneToMany(mappedBy = "nearest")
    private Set<EstateAddressNearest> estateAddressNearest = new HashSet<>();
}
