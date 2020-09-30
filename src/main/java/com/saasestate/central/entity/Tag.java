package com.saasestate.central.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "varchar(20)")
    public TagType type;

    public String name;

    public Tag(){
        super();
    }

    public Tag(int id){
        super();
        this.id = id;
    }

    public enum TagType {
        ROOMS, OTHER, ADDITIONAL, PRICE
    }

}
