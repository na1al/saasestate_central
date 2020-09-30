package com.saasestate.central.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Basic(optional = false)
    @Column(unique = true, length = 30)
    public String peId;

    @Setter
    @Getter
    @Basic
    public int price;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    public Currency currency;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    public Address address;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    private  Collection<Tag> tags = new HashSet<>();

    @Getter
    @OneToMany(mappedBy = "estate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final Set<Param> params = new HashSet<>();

    @Getter
    @OneToMany(mappedBy = "estate", cascade = CascadeType.ALL)
    private final Set<EstateAddressNearest> nearest = new HashSet<>();

    @Getter
    @ManyToMany(cascade = CascadeType.ALL)
    private final Collection<FileEntity> images = new ArrayList<>();


}
