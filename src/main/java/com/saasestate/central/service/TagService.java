package com.saasestate.central.service;


import com.saasestate.central.entity.Tag;
import com.saasestate.central.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public Optional<Tag> findOne(int id) {
        return tagRepository.findById(id);
    }

    public ArrayList<Tag> findAll() { return (ArrayList<Tag>) tagRepository.findAll(); }

    public ArrayList<Tag> findAll(List<Integer> ids) {

        if(ids.isEmpty()){
            return new ArrayList<>();
        }

        return (ArrayList<Tag>) tagRepository.findAllById(ids);
    }

    public ArrayList<Tag> findAll(Tag.TagType type) {
        return tagRepository.findAllByType(type);
    }

}
