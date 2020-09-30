package com.saasestate.central.repository;


import com.saasestate.central.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{

    public ArrayList<Tag> findAllByType(Tag.TagType type);

}
